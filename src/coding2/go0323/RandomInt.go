package main

import (
	"fmt"
	"math/rand"
)

func main() {
	//产生随机数
	fmt.Print(rand.Intn(100), ",")
	fmt.Print(rand.Intn(100))
	fmt.Println()

	fmt.Println(rand.Float64())
}
