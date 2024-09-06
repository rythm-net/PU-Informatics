import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
  name        : 'currencyTransform',
  standalone  : true
})
export class CurrencyTransformPipe implements PipeTransform {

  public transform(value: any) {

    if(value == 'USD') return '$';
    if(value == 'EUR') return '%'
    if(value == 'BGN') return '#'
    return value;
  }
}
