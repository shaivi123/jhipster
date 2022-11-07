export interface IStudent {
  id?: number;
  name?: string;
  age?: number;
  email?: string;
  phone?: string;
  address?: string;
  pinCode?: number;
}

export const defaultValue: Readonly<IStudent> = {};
