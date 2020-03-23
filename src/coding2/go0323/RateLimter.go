package main

import (
	"fmt"
	"time"
)

func main() {
	//使用chan Ticker进行速率控制
	requests := make(chan int, 5)
	for i := 1; i <= 5; i++ {
		requests <- i
	}
	close(requests)
	limter := time.Tick(200 * time.Millisecond)

	for req := range requests {
		<-limter
		fmt.Println("request", req, time.Now())
	}

	burstyLimter := make(chan time.Time, 3)

	for i := 0; i < 3; i++ {
		burstyLimter <- time.Now()
	}
	go func() {
		for t := range time.Tick(200 * time.Millisecond) {
			burstyLimter <- t
		}
	}()

	burstyRequests := make(chan int, 5)
	for i := 1; i <= 5; i++ {
		burstyRequests <- i
	}
	close(burstyRequests)
	for request := range burstyRequests {
		<-burstyLimter
		fmt.Println("request", request, time.Now())
	}
}
