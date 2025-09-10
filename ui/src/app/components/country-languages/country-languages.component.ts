import { Component, OnInit } from '@angular/core';
import { LanguageDto } from '../../dtos/language';
import { CountryService } from '../../services/country.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-country-languages',
  standalone: true,
  imports: [],
  templateUrl: './country-languages.component.html',
  styleUrl: './country-languages.component.scss'
})
export class CountryLanguagesComponent implements OnInit {
  languages: LanguageDto[] = [];

  constructor(
    private readonly countryservice: CountryService,
    private readonly route: ActivatedRoute
  ) {}

  ngOnInit() {
    const countryId = this.route.snapshot.paramMap.get('id');
    if (countryId) {
      this.countryservice.getCountryLanguages(Number(countryId))
        .subscribe(data => this.languages = data);
    }
  }
}