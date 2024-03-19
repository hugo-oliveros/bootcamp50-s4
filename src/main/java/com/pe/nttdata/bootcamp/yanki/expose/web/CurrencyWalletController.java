package com.pe.nttdata.bootcamp.yanki.expose.web;

import com.pe.nttdata.bootcamp.yanki.business.impl.CurrencyWalletBusinessImpl;
import com.pe.nttdata.bootcamp.yanki.dto.CurrencyWalletDto;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *<b>Class</b>: {@link CurrencyWalletController}<br/>
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
@RestController
@RequestMapping("currencyWallet/api/v1")
public class CurrencyWalletController {

  /**
   * .
   * CtaPrincipalController ctaPrincipalDao
   **/

  private CurrencyWalletBusinessImpl currencyWalletService;


  public CurrencyWalletController(CurrencyWalletBusinessImpl currencyWalletService) {
    this.currencyWalletService = currencyWalletService;
  }

  /**
   * </p>
   * Flux all elements from Mongo passing
   * for reactivate Flux.
   * return all elements from Mono passing
   * for reactivate Flux and return Status OK.
   *
   **/
  @RequestMapping(value = "/all")
  public Flux<com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet> getAll() {
    return currencyWalletService.findAll();
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @return {@link Mono}&lt;{@link CurrencyWalletDto}&gt;
   * @see String
   * @see Mono
   */
  @GetMapping(value = "/find/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet> find(final @PathVariable("id") @NotNull String id) {
    return currencyWalletService.findById(id);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param currencyWalletDto {@link CurrencyWalletDto}
   * @return {@link Mono}&lt;{@link CurrencyWalletDto}&gt;
   * @see String
   * @see Mono
   */
  @PostMapping(path = "/save",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet> save(final @RequestBody @NotNull
                                     CurrencyWalletDto currencyWalletDto) {
    return currencyWalletService.save(currencyWalletDto.getCurrencyWallet());
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
  @DeleteMapping(value = "/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> delete(final @PathVariable("id") @NotNull String id) {
    return currencyWalletService.deleteById(id);
  }

}
