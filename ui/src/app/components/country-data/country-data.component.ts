import { CommonModule, DecimalPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RegionDto } from '../../dtos/region';
import { CountryDataDto } from '../../dtos/country-data';
import { CountryDataService } from '../../services/country-data.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-country-data',
  standalone: true,
  imports: [DecimalPipe, CommonModule, FormsModule],
  templateUrl: './country-data.component.html',
  styleUrl: './country-data.component.scss'
})
export class CountryDataComponent implements OnInit {
  data: any[] = [];
  page = 0;          // current page index
  size = 20;         // rows per page
  totalPages = 0;    // total number of pages
  totalElements = 0; // total rows
  regions: RegionDto[] = [];
  countryData: CountryDataDto[] = [];
  selectedRegion: number | '' = '';
  yearFrom: number | null = null;
  yearTo: number | null = null;

  constructor(private readonly dataService: CountryDataService) {}

  ngOnInit() {
    this.dataService.getRegions().subscribe(
      (res: RegionDto[]) => this.regions = res
    );
    this.loadData();
  }

  loadData() {
    this.dataService.getCountryDataPaginated(
        this.page,
        this.size,
        this.selectedRegion || undefined,
        this.yearFrom || undefined,
        this.yearTo || undefined
    ).subscribe({
      next: (res: any) => {
        this.data = res.content; // Spring Data returns `content` array
        this.countryData = res.content as CountryDataDto[];
        this.totalPages = res.totalPages;
        this.totalElements = res.totalElements;

      },
      error: (err: any) => console.error('Error fetching country data:', err)
    });
  }

  nextPage() {
    if (this.page < this.totalPages - 1) {
      this.page++;
      this.loadData();
    }
  }

  prevPage() {
    if (this.page > 0) {
      this.page--;
      this.loadData();
    }
  }

  changePageSize(event: any) {
    this.size = +event.target.value; // new size
    this.page = 0; // reset to first page
    this.loadData();
  }

  applyFilters() {
    this.loadData();
  }
}