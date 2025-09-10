import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CountryDto } from '../dtos/country';
import { LanguageDto } from '../dtos/language';

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  private readonly apiUrl = '/api/countries';

  constructor(private readonly http: HttpClient) { }

  getCountries(): Observable<CountryDto[]> {
    return this.http.get<CountryDto[]>(this.apiUrl);
  }
  
  getCountryLanguages(id: number): Observable<LanguageDto[]> {
    return this.http.get<LanguageDto[]>(`${this.apiUrl}/${id}/languages`);
  }
}
