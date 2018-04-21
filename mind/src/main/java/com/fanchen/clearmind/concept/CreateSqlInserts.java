package com.fanchen.clearmind.concept;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class CreateSqlInserts {

	public static void main(String[] args) {

		try {

			List<String> queries = new ArrayList<>();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream("/Users/fan/Desktop/CBO-2108/csvs/charge_type_default_comments_config.csv"),
					StandardCharsets.UTF_8));

			queries = br.lines().skip(1).filter(line -> !line.isEmpty()).map(updateChargeDefaultComments)
					.collect(Collectors.toList());

			br.close();

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("/Users/fan/Desktop/CBO-2108/sql/charge_type_default_comments_config.sql"),
					StandardCharsets.UTF_8));

			System.out.println(queries.size());
			for (String query : queries) {
				if (query != null && !query.trim().isEmpty()) {
					out.write(query + "\n\n");
				}

			}
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static Function<String, String> mapToFootComments = (line) -> {
		String[] p = line.split(",");// a CSV has comma separated lines

		if (p != null && p.length > 0) {
			String query = "INSERT INTO transaction_comments_config " + "(vat_sect, lang, "
					+ "operating_cntry_cd, fin_party_type_cd, export_type, chrg_cat_cd, "
					+ "doc_type_cd, comments1, comments2, comments_seq, status, "
					+ "crt_dt, crt_user, last_upd_dt, last_upd_user) " + "VALUES ( ";

			p[1] = StringUtils.isBlank(p[1]) ? "" : p[1];
			query = query + "'" + p[1] + "', ";
			// export type
			query = query + "'" + p[2] + "', ";
			// party
			query = query + "'" + p[3] + "', ";
			// country
			query = query + "'" + p[4] + "', ";
			// account entry type
			query = query + "'" + p[5] + "', ";
			// Ledger
			query = query + "'" + p[6] + "', ";
			// country
			query = query + "'" + p[7] + "', ";
			// account entry type
			query = query + "'" + p[8] + "', ";
			// Ledger
			p[1] = StringUtils.isBlank(p[9]) ? "" : p[9];
			query = query + "'" + p[9] + "', ";
			// country
			query = query + "'" + p[10] + "', ";
			// account entry type
			query = query + "'" + p[11] + "', ";
			// Ledger
			query = query + "'" + p[12] + "', ";

			query = query + "'" + p[13] + "',";

			query = query + "'" + p[14] + "', ";
			// Ledger

			query = query + "'" + p[15] + "');";
			return query;
		}
		return "";
	};

	/**
	 * 
	 * UPDATE charge_type_default_comments_config SET comments_tmpl = 'Condition
	 * Report <br/>
	 * for the above LOT' WHERE fin_event_type_cd = 'SLRINVACM' AND chrg_type_cd =
	 * 'CNDTNRPT' AND operating_cntry_cd = 'DEU' AND fin_party_type_cd = 'SLR' AND
	 * bill_type_cd = 'INV' AND lang = 'EN';
	 * 
	 */
	private static Function<String, String> updateChargeDefaultComments = (line) -> {
		String[] p = line.split(",");// a CSV has comma separated lines

		if (p != null && p.length > 0) {
			String query = "UPDATE  charge_type_default_comments_config " + "SET comments_tmpl = ";

			query = query + "'" + p[8] + "' ";

			query = query + " WHERE fin_event_type_cd = ";

			query = query + "'" + p[1] + "' AND ";

			query = query + "  chrg_type_cd = ";

			query = query + "'" + p[2] + "' AND ";

			query = query + "  operating_cntry_cd = ";

			query = query + "'" + p[3] + "' AND ";

			query = query + "  fin_party_type_cd = ";

			query = query + "'" + p[4] + "' AND ";

			query = query + "  bill_type_cd = ";

			query = query + "'" + p[5] + "' AND ";

			query = query + "  lang = ";

			query = query + "'" + p[6] + "');";

			return query;
		}
		return "";
	};

}
