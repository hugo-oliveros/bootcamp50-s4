package com.pe.nttdata.bootcamp.yanki.dao;

import com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>interface</b>: {@link CurrencyWalletDao}<br/>
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

@Repository
public interface CurrencyWalletDao {

  public Flux<CurrencyWallet>  findAll();

  public Mono<CurrencyWallet> findById(String id);

  public Mono<CurrencyWallet> findByCustomerIdentityNumber(String identityNumber);

  public Mono<CurrencyWallet> save(CurrencyWallet currencyWallet);

  public Mono<Void> deleteById(String id);

}
