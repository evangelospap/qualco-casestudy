import { Component, OnInit } from '@angular/core';
import { CountryDto } from '../../dtos/country';
import { CountryService } from '../../services/country.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-countries',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './countries.component.html',
  styleUrl: './countries.component.scss'
})
export class CountriesComponent implements OnInit {
  countries: CountryDto[] = [];

  constructor(private readonly service: CountryService, private readonly router: Router) {}

  ngOnInit() {
    this.service.getCountries().subscribe(
      data => {
        this.countries = data
      }
    );
  }

  viewLanguages(id: number) {
    this.router.navigate(['/countries', id, 'languages'], { queryParams: { name: this.countries.find(c => c.id === id)?.name } });
  }
}