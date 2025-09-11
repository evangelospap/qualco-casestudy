// src/app/services/country-stats.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CountryStatDto } from '../dtos/country-stats';

@Injectable({ providedIn: 'root' })
export class CountryStatsService {
  private readonly apiUrl = '/api/countries/stats';

  constructor(private readonly http: HttpClient) {}

  getStats(): Observable<CountryStatDto[]> {
    return this.http.get<CountryStatDto[]>(this.apiUrl);
  }
}
