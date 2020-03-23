package go0322

import (
	"fmt"
	"net/http"
)

func main() {

	http.HandleFunc("/hello", hello)
	http.HandleFunc("/headers", headers)

	http.ListenAndServe(":8913",nil)
	
}

func hello(w http.ResponseWriter,req * http.Request)  {

	fmt.Fprint(w,"hello \n")
}

func headers(w http.ResponseWriter ,req *http.Request)  {


	for name, headers := range req.Header{
		for _,h :=range headers{
			fmt.Fprint(w,"%v: %v\n",name,h)
		}
	}
}