package com.example.demo.controller;

import com.example.demo.beans.UserModel;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String getHome(){
        return "Hello World";
    }


    @PostMapping("/user/create")
    public String createUser(@RequestBody UserModel user){
        UserModel u1 = userRepository.findByEmail(user.getEmail());
        if(u1 == null){
            userRepository.save(user);
           return "SUCCESS";
        }else{
            u1.setPassword(user.getPassword());
            userRepository.save(u1);
           return "USER ALREADY EXISTS";
        }
    }
}


/**
 * exchange --> (NSE, BSE, SENSEX ) -> id, name
 * candle --> Open, High,Low, Close, scriptID, timestamp, exchangeID
 * script --> id, name(e. reliance) ::> one to many with candle
 * products --> CASH, FUTURES, OPTIONS(CALL & PUT) ::> id, name
 * FII : CASH > 0 : BUY, else SELL, similarly futures & options
 * fii_info --> id, productID, value, timestamp
 * dii_info --> id, productID, value, timestamp
 * market_verdict --> id,timestamp, fii_sentiment_cash,fii_sentiment_future,fii_sentiment_call_optipns, fii_sentiment_put_optipns,
 *            dii_sentiment_cash,dii_sentiment_future,dii_sentiment_call_optipns, dii_sentiment_put_optipns, overall_sentiment(BULLISH, BEARISH, SIDEWAYS)
 * result_analytics -->  id, previous_verdict, intraday_move, result, timestamp
 */

// SELECT candle.low from candle
//    JOIN scripts ON candle.scriptID = script.id
//    JOIN exchange ON exchange.id = candle.exchangeID WHERE script.name = 'RELIANCE' AND exchange.name = 'NSE';