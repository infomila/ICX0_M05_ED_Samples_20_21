package net.iesmila.ED.UF2.capsa_negra;


public enum TipusCanvi {
  VENDA_OK_CANVI_EXACTE, // es fa la venda i retorna el canvi exacte
  VENDA_OK_NO_TE_CANVI,   // es fa la venda, però retorna menys quantitat ja que no té prou canvi
  VENDA_FAIL_IMPORT_INSUFICIENT, // no fa la venda, el client no ha posat prous monedes
  VENDA_FAIL_ERROR_DADES   // no fa la venda, hi ha error a les dades proporcionades.
}
