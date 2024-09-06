import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root"
})
export class TodoListService {

  public generateStatusBasedOnMath() {

    const coeficient =  Math.random();

    if(coeficient < 0.7) return 'todo';
    return 'doing';
  }
}
