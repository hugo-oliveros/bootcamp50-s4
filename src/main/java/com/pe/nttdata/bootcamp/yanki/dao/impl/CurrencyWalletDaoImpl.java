package com.pe.nttdata.bootcamp.yanki.dao.impl;

import com.pe.nttdata.bootcamp.yanki.dao.repository.CurrencyWalletRepository;
import com.pe.nttdata.bootcamp.yanki.dao.CurrencyWalletDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>Class</b>: {@link CurrencyWalletDaoImpl}<br/>
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
 *<li>Mar. 8, 2024 (acronym) Creation class.</li>
 *</ul>
 *@version 1.0
 */
@Service
public class CurrencyWalletDaoImpl implements CurrencyWalletDao{

  @Autowired
  private CurrencyWalletRepository currencyWalletRepository;


  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Flux}&lt;{@link com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet}&gt;
   * @see String
   * @see Flux
   */
  @Override
  public Flux<com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet> findAll() {
    return currencyWalletRepository.findAll();
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @return {@link Mono}&lt;{@link com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public Mono<com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet> findById(String id) {
    return currencyWalletRepository.findById(id);
  }


  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param identityNumber {@link String}
   * @return {@link Mono}&lt;{@link com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public Mono<com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet> findByCustomerIdentityNumber(String identityNumber){
    return currencyWalletRepository.findByCustomerIdentityNumber(identityNumber);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param currencyWallet {@link String}
   * @return {@link Mono}&lt;{@link com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public Mono<com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet> save(com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet currencyWallet) {
    return currencyWalletRepository.save(currencyWallet);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @return {@link Mono}&lt;{@link Void}&gt;
   * @see String
   * @see Mono
   * @see Void
   */
  @Override
  public Mono<Void> deleteById(String id) {
    return currencyWalletRepository.deleteById(id);
  }

}