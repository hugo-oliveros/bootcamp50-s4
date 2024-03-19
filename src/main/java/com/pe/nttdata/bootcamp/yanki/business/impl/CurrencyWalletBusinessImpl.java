package com.pe.nttdata.bootcamp.yanki.business.impl;

import com.pe.nttdata.bootcamp.yanki.commons.OperationEnum;
import com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet;
import com.pe.nttdata.bootcamp.yanki.service.CurrencyWalletService;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>Class</b>: {@link CurrencyWalletBusinessImpl}<br/>
 *<b>Copyright</b>: &Copy; 2024 NTTDATA Per&uacute;. <br/>
 *<b>Company</b>: NTTDATA del Per&uacute;. <br/>
 *
 *@author NTTDATA Per&uacute;. (EVE) <br/>
 *<u>Developed by</u>: <br/>
 *<ul>
 *<li>Hugo Oliveros Monti</li>
 *</ul>
 *<u>Changes</u>:<br/>
 *<ul>
 *<li>feb. 29, 2024 (acronym) Creation class.</li>
 *</ul>
 *@version 1.0
 */
@Service
@Slf4j
public class CurrencyWalletBusinessImpl{


  private CurrencyWalletService currencyWalletService;


    public CurrencyWalletBusinessImpl(CurrencyWalletService currencyWalletService) {
        this.currencyWalletService = currencyWalletService;
    }

  private CurrencyWallet movError;



  public Flux<CurrencyWallet> findAll() {
    return currencyWalletService.findAll();
  }


  public Mono<CurrencyWallet> findById(String id) {
    return currencyWalletService.findById(id);
  }


  public Mono<CurrencyWallet> save(CurrencyWallet currencyWallet) {
    return currencyWalletService.findByCustomerIdentityNumber(
              currencyWallet.getCustomer().getIdentityNumber())
              .log("Entering the CurrencyWallet save operation.")
              .map(res -> {
                if (res.getOperations() == null || res.getOperations().isEmpty()) {
                  res.setOperations(new ArrayList<>());
                }

                return res;
              })
              .flatMap(operation -> {
                double sum = operation.getOperations().stream()
                          .collect(Collectors.summingDouble(d -> d.getAmount()));
                if (Double.compare(sum, operation.getCurrencyCoinAmount()) < 0) {
                  operation.getOperations().addAll(currencyWallet.getOperations());
                  return currencyWalletService.save(operation);
                } else {
                  movError =  CurrencyWallet.builder().build();
                  movError.setDescription("The amount exceeds what is allowed, please verify");
                  return Mono.just(movError);
                }

              })
              .switchIfEmpty(Mono.defer(() -> {
                currencyWallet.setStatus(OperationEnum.OK.value());
                return currencyWalletService.save(currencyWallet);
              }).onErrorResume(error -> {
                movError = CurrencyWallet.builder().build();
                movError.setDescription("Error found...: "
                        + error);
                return Mono.just(movError);
              }));
  }


  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @param currencyWallet {@link CurrencyWallet}
   * @return {@link Mono}&lt;{@link CurrencyWallet}&gt;
   * @see String
   * @see Mono
   */

  public  Mono<CurrencyWallet> update(final String id, final CurrencyWallet currencyWallet) {
    return currencyWalletService.findById(id)
            .map(Optional::of)
            .defaultIfEmpty(Optional.empty())
            .flatMap(optional -> {
              if (optional.isPresent()) {
                currencyWallet.setId(new ObjectId(id));
                return currencyWalletService.save(currencyWallet);
              }
              return Mono.empty();
            });
  }


  public Mono<Void> deleteById(String id) {
    return currencyWalletService.deleteById(id);
  }

}
