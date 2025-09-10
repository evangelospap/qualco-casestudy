export interface CountryDto {
  id: number;
  name: string;
  area: number;
  nationalDay: Date;
  countryCode2: string;
  countryCode3: string;
  regionId: number;
  stats : [any];
  languages : [any]
}