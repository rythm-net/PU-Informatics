import { HttpClient } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { lastValueFrom } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class TodoApiService {

  // REST API
  // - HTTP
  // GET / POST / PUT / DELETE

  // GET    - взимаме данни
  // POST   - създаваме нова информация
  // PUT    - актуализираме съществуващи данни
  // DELETE - изтриваме

  private http = inject(HttpClient)

  public getAllTodos() {

    // Превърни ми обекта Observer в Promise
    return lastValueFrom(this.http.get(`https://dummyjson.com/todos`))
  }

  // взима конкретен TODO обект
  // - да връща Promise
  public getSingleTodo(id) {
    return lastValueFrom(this.http.get(`https://dummyjson.com/todos/${id}`))
    // return lastValueFrom(this.http.get(`https://dummyjson.com/todos/` + id))
  }
}
