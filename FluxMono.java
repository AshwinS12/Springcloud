package com.example.demo;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxMono {
	
	public Mono<List<String>> fruitMono(){
		return Mono.just("Mango").flatMap(s->Mono.just(List.of(s.split(""))).log());
	}
	public Flux<String>fruitflux(){
		return Mono.just("Mango").flatMapMany(s->Flux.just(s.split(""))).log();
	}
public Mono<String> fruits(){
	var fruits = Mono.just("Apples");
	var veggies = Mono.just("Cauliflower");
	return fruits.zipWith(veggies,(first,second)->first+second).log();
}
	public static void main(String[] args) {
    FluxMono fl = new FluxMono();
    fl.fruits().subscribe(s->{System.out.println("Mono-> s ="+s);
    });
    fl.fruitflux().subscribe(s->{System.out.println("Mono-> s ="+s);
    });
    System.out.println("_____________");
    fl.fruitflux().subscribe(s->{System.out.println("Mono->s ="+s);});
    
    System.out.println("Changed");
    }

	
	}

