package pl.britenet.campus.command;

import pl.britenet.campus.Constants;
import pl.britenet.campus.object.Product;
import pl.britenet.campus.service.ProductService;

import java.util.List;

public class RetrieveProductsCommand extends Command {

    private final ProductService productService;

    public RetrieveProductsCommand(ProductService productService) {
        super(Constants.COMMAND_RETRIEVE_PRODUCTS);
        this.productService = productService;
    }

    @Override
    public void execute() {
        List<Product> productList = this.productService.getProducts();
        productList.forEach( product -> {
            System.out.println(product.getName());
        } );
    }
}
