import { HttpClient } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";

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
    return this.http.get(`https://dummyjson.com/todos`)
  }
}
