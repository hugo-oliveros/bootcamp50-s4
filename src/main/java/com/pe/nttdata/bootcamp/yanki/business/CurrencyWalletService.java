package com.pe.nttdata.bootcamp.yanki.business;

import com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>Interface</b>: {@link CurrencyWalletService}<br/>
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


public interface CurrencyWalletService {

  Flux<CurrencyWallet> findAll();

  Mono<CurrencyWallet> findById(String id);

  Mono<CurrencyWallet> save(CurrencyWallet currencyWallet);

  Mono<CurrencyWallet> update(final String id, final CurrencyWallet currencyWallet);

  Mono<Void> deleteById(String id);

}
