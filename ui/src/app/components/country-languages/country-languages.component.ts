import { Component, OnInit } from '@angular/core';
import { LanguageDto } from '../../dtos/language';
import { CountryService } from '../../services/country.service';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-country-languages',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './country-languages.component.html',
  styleUrl: './country-languages.component.scss'
})
export class CountryLanguagesComponent implements OnInit {
  languages: LanguageDto[] = [];
  countryName: string | null = null;

  constructor(
    private readonly countryservice: CountryService,
    private readonly route: ActivatedRoute
  ) {}

  ngOnInit() {
    const countryId = this.route.snapshot.paramMap.get('id');
    this.countryName = this.route.snapshot.queryParamMap.get('name');
    if (countryId) {
      this.countryservice.getCountryLanguages(Number(countryId))
        .subscribe(data => this.languages = data);
    }
  }
}