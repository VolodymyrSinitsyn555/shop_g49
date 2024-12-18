package ait.cohort49.shop.controller;

import ait.cohort49.shop.model.dto.ProductDTO;
import ait.cohort49.shop.service.interfaces.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;



@RestController
@RequestMapping("/products")
@Tag(name = "Product controller", description = "Controller for operations with products")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create product", description = "Add new product", tags = {"Product"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class)),
                            @Content(mediaType = "application/xml", schema = @Schema(implementation = ProductDTO.class))
                    })
    })
    @PostMapping
    public ProductDTO saveProduct(@RequestBody ProductDTO productDto) {
        return productService.saveProduct(productDto);
    }

    @Operation(summary = "Get product by id", tags = {"Product"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = ProductDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content) })
    @GetMapping("/{productId}")
    public ProductDTO getById(
            @Parameter(description = "The id that needs to be fetched", required = true)
            @PathVariable("productId") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAllActiveProducts();
    }


    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO productDto){
        return productService.updateProduct(id, productDto);
    }

    // Delete: DELETE -> /products/3
    @DeleteMapping("/{id}")
    public ProductDTO remove(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    // Delete: DELETE -> /products/by-title?title=Banana
    @DeleteMapping("/by-title")
    public ProductDTO deleteProductByTitle(@RequestParam String title) {
        return productService.deleteProductByTitle(title);
    }

    // PUT -> /products/restore/25
    @PutMapping("/restore/{id}")
    public ProductDTO restoreProductById(@PathVariable Long id) {
        return productService.restoreProductById(id);
    }

    @GetMapping("/count")
    public long getProductsCount() {
        return productService.getProductsCount();
    }

    @GetMapping("/total-price")
    public BigDecimal getTotalPrice() {
        return productService.getTotalPrice();
    }

    @GetMapping("/average-price")
    public BigDecimal getAveragePrice() {
        return productService.getAveragePrice();
    }
}
