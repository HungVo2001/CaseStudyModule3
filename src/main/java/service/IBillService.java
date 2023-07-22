package service;

import model.Bill;

public interface IBillService {
    Bill findPayment(long id);

    Bill createBill(long idUser);
    Bill getBillById(long idUser);
}
