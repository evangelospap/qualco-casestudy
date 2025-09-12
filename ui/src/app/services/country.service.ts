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
  private readonly countryMap = new Map<number, CountryDto>();

  setCountry(country: CountryDto) {
    this.countryMap.set(country.id, country);
  }

  getCountry(id: number): CountryDto | undefined {
    return this.countryMap.get(id);
  }

  constructor(private readonly http: HttpClient) { }

  getCountries(): Observable<CountryDto[]> {
    return this.http.get<CountryDto[]>(this.apiUrl);
  }
  
  getCountryLanguages(id: number): Observable<LanguageDto[]> {
    return this.http.get<LanguageDto[]>(`${this.apiUrl}/${id}/languages`);
  }
}
