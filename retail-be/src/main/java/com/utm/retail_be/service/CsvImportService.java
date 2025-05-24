
package com.utm.retail_be.service;

import com.utm.retail_be.entity.*;
import com.utm.retail_be.mapper.*;
import com.utm.retail_be.repository.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CsvImportService {

    private final DateDetailsRepository dateDetailsRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentDetailRepository paymentDetailRepository;
    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;
    private final DiscountRepository discountRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final CountryRepository countryRepository;
    private final CustomerCategoryRepository customerCategoryRepository;
    private final SupplierRepository supplierRepository;

    public CsvImportService(DateDetailsRepository dateDetailsRepository,
                            PaymentRepository paymentRepository,
                            PaymentDetailRepository paymentDetailRepository,
                            ProductRepository productRepository,
                            ShopRepository shopRepository,
                            DiscountRepository discountRepository,
                            ProductCategoryRepository productCategoryRepository,
                            CountryRepository countryRepository,
                            CustomerCategoryRepository customerCategoryRepository,
                            SupplierRepository supplierRepository) {
        this.dateDetailsRepository = dateDetailsRepository;
        this.paymentRepository = paymentRepository;
        this.paymentDetailRepository = paymentDetailRepository;
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
        this.discountRepository = discountRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.countryRepository = countryRepository;
        this.customerCategoryRepository = customerCategoryRepository;
        this.supplierRepository = supplierRepository;
    }

    public int importSales(InputStream stream) throws Exception {
        List<DateDetails> allDates = dateDetailsRepository.findAll();
        Map<LocalDate, DateDetails> dateMap = allDates.stream()
                .collect(Collectors.toMap(
                    DateDetails::getDataBonDate,
                        d -> d
                ));

        List<Payment> payments = new ArrayList<>();
        List<PaymentDetail> details = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.ISO_8859_1));
        String line;
        boolean skip = true;
        while ((line = reader.readLine()) != null) {
            if (skip) { skip = false; continue; }
            String[] row = line.split(",");
            Payment payment = SalesMapper.fromCsvRow(row, dateMap);
            PaymentDetail detail = SalesMapper.fromCsvRow(row);
            detail.setPayment(payment);
            payments.add(payment);
            details.add(detail);
        }

        paymentRepository.saveAll(payments);
        paymentDetailRepository.saveAll(details);
        return payments.size();
    }

    public int importProducts(InputStream stream) throws Exception {
        List<Product> products = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.ISO_8859_1));
        String line;
        boolean skip = true;
        while ((line = reader.readLine()) != null) {
            if (skip) { skip = false; continue; }
            String[] row = line.split(",");
            Product product = ProductMapper.fromCsv(row);
            ProductCategory pc = productCategoryRepository.findByName(product.getProductCategory().getName())
                .orElseGet(() -> productCategoryRepository.save(product.getProductCategory()));
            product.setProductCategory(pc);
            products.add(product);
        }
        productRepository.saveAll(products);
        return products.size();
    }

    public int importShops(InputStream stream) throws Exception {
        List<Shop> shops = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.ISO_8859_1));
        String line;
        boolean skip = true;
        while ((line = reader.readLine()) != null) {
            if (skip) { skip = false; continue; }
            String[] row = line.split(",");
            Shop shop = ShopMapper.fromCsv(row);
            Country country = countryRepository.findByName(shop.getCountry().getName())
                .orElseGet(() -> countryRepository.save(shop.getCountry()));
            shop.setCountry(country);
            shops.add(shop);
        }
        shopRepository.saveAll(shops);
        return shops.size();
    }

    public int importDiscounts(InputStream stream) throws Exception {
        List<Discount> discounts = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.ISO_8859_1));
        String line;
        boolean skip = true;
        while ((line = reader.readLine()) != null) {
            if (skip) { skip = false; continue; }
            String[] row = line.split(",");
            discounts.add(DiscountMapper.fromCsv(row));
        }
        discountRepository.saveAll(discounts);
        return discounts.size();
    }

    public int importDateDetails(InputStream stream) throws Exception {
        List<DateDetails> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.ISO_8859_1));
        String line;
        boolean skip = true;
        while ((line = reader.readLine()) != null) {
            if (skip) { skip = false; continue; }
            String[] row = line.split(",");
            list.add(DateDetailsMapper.fromCsv(row));
        }
        dateDetailsRepository.saveAll(list);
        return list.size();
    }
}
