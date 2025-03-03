package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.ProductModel;
import com.gcu.model.ProductsList;

@RestController
@RequestMapping("/service")
public class ProductsRestService {
	
	private ProductsBusinessInterface service;

	/**
     * Setter for the ProductsBusinessInterface dependency.
     * 
     * @param service The ProductsBusinessInterface implementation.
     */
    @Autowired
    public void setService(ProductsBusinessInterface service) {
        this.service = service;
    }

    /**
     * Retrieves products data in JSON format.
     * 
     * @return A list of ProductModel objects serialized to JSON.
     */
    @GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductModel> getOrderAsJson() {
        return service.getProducts();
    }
    
    /**
     * Retrieves products data in XML format.
     * 
     * @return An ProductsList object containing the list of products serialized to XML.
     */
    @GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
    public ProductsList getProductssAsXml() {
        ProductsList list = new ProductsList();
        list.setProducts(service.getProducts());
        return list;
    }
    
    /**
     * return a filtered list of the products
     * @param searchTerm
     * @return
     */
    @GetMapping(path="/search", produces= {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductModel> searchProducts(@RequestParam String searchTerm) {
        return service.searchProducts(searchTerm);
    }
}
