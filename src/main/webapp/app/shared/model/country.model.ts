export interface ICountry {
  id?: number;
  countryName?: string;
  city?: string;
}

export const defaultValue: Readonly<ICountry> = {};
