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

  getCountryDataPaginated(page: number, size: number,regionId?: number, yearFrom?: number, yearTo?: number){
    // let query = '?';
    // if (regionId) query += `regionId=${regionId}&`;
    // if (yearFrom) query += `yearFrom=${yearFrom}&`;
    // if (yearTo) query += `yearTo=${yearTo}&`;
    // return this.http.get(this.apiUrl + query);

    let params: any = { page, size };
    if (regionId) params.regionId = regionId;
    if (yearFrom) params.yearFrom = yearFrom;
    if (yearTo) params.yearTo = yearTo;

  return this.http.get<any>('/api/country-data', { params });
}

  getRegions(): Observable<RegionDto[]> {
    return this.http.get<RegionDto[]>(this.regionsUrl);
  }
}