package com.pe.nttdata.bootcamp.yanki.dao.repository;

import com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


/**
 *<b>Class</b>: {@link CurrencyWalletRepository}<br/>
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
public interface CurrencyWalletRepository extends ReactiveMongoRepository<CurrencyWallet, String> {

  @Query(value = "{ 'customer.identityNumber': {$eq:?0}  } ")
  Mono<CurrencyWallet> findByCustomerIdentityNumber(String identityNumber);

}
