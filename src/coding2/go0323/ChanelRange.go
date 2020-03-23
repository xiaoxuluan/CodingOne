package main

import "fmt"

func main() {

	//可以 通过for 和range来遍历通道
	queue := make(chan string, 2)
	queue <- "one"
	queue <- "two"

	close(queue)

	for elem := range queue {
		fmt.Println(elem)
	}

}
