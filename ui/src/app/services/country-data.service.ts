import { HttpClient } from "@angular/common/http";
import { CountryDataDto } from "../dtos/country-data";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { RegionDto } from "../dtos/region";

@Injectable({ providedIn: 'root' })
export class CountryDataService {
  private readonly apiUrl = '/api/country-data';
  private readonly regionsUrl = '/api/regions';

  constructor(private readonly http: HttpClient) {}

  getCountryData(regionId?: number, yearFrom?: number, yearTo?: number): Observable<CountryDataDto[]> {
    let query = '?';
    if (regionId) query += `regionId=${regionId}&`;
    if (yearFrom) query += `yearFrom=${yearFrom}&`;
    if (yearTo) query += `yearTo=${yearTo}&`;
    return this.http.get<CountryDataDto[]>(this.apiUrl + query);
  }

  getRegions(): Observable<RegionDto[]> {
    return this.http.get<RegionDto[]>(this.regionsUrl);
  }
}