import { Component, OnInit } from '@angular/core';
import { LanguageDto } from '../../dtos/language';
import { CountryService } from '../../services/country.service';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { CountryDto } from '../../dtos/country';

@Component({
  selector: 'app-country-languages',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './country-languages.component.html',
  styleUrl: './country-languages.component.scss'
})
export class CountryLanguagesComponent implements OnInit {
  country?: CountryDto;
  languages: LanguageDto[] = [];
  countryName: string | null = null;

  constructor(
    private readonly countryService: CountryService,
    private readonly route: ActivatedRoute
  ) {}

  ngOnInit() {
    const countryId = Number(this.route.snapshot.paramMap.get('id'));
    this.countryName = this.countryService.getCountry(countryId)?.name || null;
    if (countryId) {
      this.countryService.getCountryLanguages(countryId)
        .subscribe(data => this.languages = data);
    }
  }
}