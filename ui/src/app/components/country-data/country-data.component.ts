import { CommonModule, DecimalPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RegionDto } from '../../dtos/region';
import { CountryDataDto } from '../../dtos/country-data';
import { CountryDataService } from '../../services/country-data.service';

@Component({
  selector: 'app-country-data',
  standalone: true,
  imports: [DecimalPipe, CommonModule],
  templateUrl: './country-data.component.html',
  styleUrl: './country-data.component.scss'
})
export class CountryDataComponent implements OnInit {
  regions: RegionDto[] = [];
  countryData: CountryDataDto[] = [];
  selectedRegion: number | '' = '';
  yearFrom: number | null = null;
  yearTo: number | null = null;

  constructor(private readonly dataService: CountryDataService) {}

  ngOnInit() {
    this.dataService.getRegions().subscribe((r: RegionDto[]) => this.regions = r);
    this.loadData();
  }

  loadData() {
    this.dataService.getCountryData(
      this.selectedRegion || undefined,
      this.yearFrom || undefined,
      this.yearTo || undefined
    ).subscribe(d => this.countryData = d);
  }

  applyFilters() {
    this.loadData();
  }
}