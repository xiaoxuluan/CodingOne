package main

import (
	"fmt"
	"sort"
)

func main() {


	strs := []string{"C","A","B"}
	sort.Strings(strs)
	fmt.Println(strs)

	ints :=[]int{1,3,2,6,8,4,11}
	sort.Ints(ints)
	fmt.Println(ints)

	//判断一个数组是否有序
	s := sort.IntsAreSorted(ints)
	fmt.Println(s)
}
