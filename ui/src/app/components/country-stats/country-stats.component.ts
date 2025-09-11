// src/app/components/country-stats/country-stats.component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CountryStatsService } from '../../services/country-stats.service';
import { CountryStatDto } from '../../dtos/country-stats';

@Component({
  selector: 'app-country-stats',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './country-stats.component.html',
  styleUrls: ['./country-stats.component.scss']
})
export class CountryStatsComponent implements OnInit {
  stats: CountryStatDto[] = [];

  constructor(private readonly statsService: CountryStatsService) {}

  ngOnInit() {
    this.statsService.getStats().subscribe(data => this.stats = data);
  }
}
