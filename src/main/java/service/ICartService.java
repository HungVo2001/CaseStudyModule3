package service;

import model.Cart;

public interface ICartService {
    Cart getCartById(long idUser);
    Cart createCart(Cart cart);

    Cart updateCart(Cart cart);

    void addToCart(int idProduct, int quantity, long id);


    Cart updateCartInfo(long idUser, long idProduct, int quantity);



}