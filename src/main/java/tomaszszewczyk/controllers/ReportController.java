package tomaszszewczyk.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tomaszszewczyk.entities.ProductReport;
import tomaszszewczyk.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportController {

    @Data
    public static class ProductSalesQueryDTO {
        private Integer productID;
        private Date from;
        private Date to;
    }

    @Data
    public static class ProductSalesReportDTO {
        private Integer productID;
        private Date from;
        private Date to;
        private Integer count;
    }

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @GetMapping("/productReport")
    public List<ProductReport> getProductSalesReport() {
        return productRepository.generateReport();
    }
}
