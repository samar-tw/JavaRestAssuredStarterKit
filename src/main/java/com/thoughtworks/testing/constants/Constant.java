package com.thoughtworks.testing.constants;

/**
 * A class to store all the API endpoint constants.
 */
public class Constant {

//    private Constant() {
//        // Private constructor to prevent instantiation of this utility class.
//    }

    /**
     * API endpoints related to users.
     */
    public static class UserEndpoints {
        public static final String GET_USERS = "/api/users?page=";
        public static final String CREATE_USER = "/api/users";
        public static final String UPDATE_USER = "/api/users/{id}";
        public static final String DELETE_USER = "/api/users/{id}";
    }

    /**
     * API endpoints related to products.
     */
    public static class ProductEndpoints {
        public static final String GET_PRODUCTS = "/api/products";
        public static final String CREATE_PRODUCT = "/api/products";
        public static final String UPDATE_PRODUCT = "/api/products/{id}";
        public static final String DELETE_PRODUCT = "/api/products/{id}";
    }

}