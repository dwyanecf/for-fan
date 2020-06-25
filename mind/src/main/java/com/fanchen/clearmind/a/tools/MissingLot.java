/*
 * Copyright (C) 2020 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.a.tools;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fachen
 *
 */
public class MissingLot {

	public static void main(String[] args) {
		List<String> dev4 = Arrays.asList("DATABASECHANGELOG", "DATABASECHANGELOGLOCK", "addresses",
				"application_messages", "bill_attributes", "bill_clearing_transactions", "bill_details",
				"bill_entity_account_posting_config", "bill_number_generation_config", "bill_number_generation_log",
				"bill_status", "bill_types", "bills", "cas_bds_charge_code_mapping", "charge_attributes",
				"charge_attributes_config", "charge_bill_status", "charge_categories",
				"charge_category_default_vat_sections_config", "charge_group_ir_status_config",
				"charge_type_default_comments_config", "charge_type_financial_posting_config",
				"charge_type_revenue_recognition_config", "charge_types", "charges", "charges_staging", "check_details",
				"check_sequence_data", "check_types", "check_verification_provider_config", "client_event_action_logs",
				"client_event_entity_snapshot", "client_event_request_logs", "client_events",
				"client_to_financial_event_mapping", "communication_types", "communications", "config_staging",
				"copart_financial_hierarchy", "copart_fiscal_year_config", "copart_ops_hierarchy", "countries",
				"dimension_attributes_config", "dimension_attributes_data_map", "dimension_config", "dimension_data",
				"dimension_nav_map", "document_associations", "document_delivery", "document_delivery_email_config",
				"document_delivery_type_config", "document_delivery_types", "document_templates", "document_types",
				"documents", "dp_to_client_event_mapping", "electronics", "email_template_subject_config",
				"email_templates", "entity_communication_preferences", "entity_types", "error_logs",
				"event_attributes_config", "event_default_charges_mapping", "event_template_attributes",
				"event_templates", "external_invoice_details", "external_invoice_discrepancies", "external_invoices",
				"external_response_logs", "external_tax_bill_attributes", "external_tax_bill_details",
				"external_tax_bills", "external_tax_mapping", "file_formats", "financial_account_transaction_details",
				"financial_account_transaction_discrepancies", "financial_accounts",
				"financial_entity_payment_mode_attributes_config", "financial_event_action_logs",
				"financial_event_bill_type_charge_type_config", "financial_event_bill_type_config",
				"financial_event_bill_type_document_type_config", "financial_event_generation_config",
				"financial_event_request_logs", "financial_event_transaction_data", "financial_events",
				"financial_institution_account_app_association", "financial_institution_accounts",
				"financial_institution_branches", "financial_institution_file_formats",
				"financial_institution_file_transaction_codes", "financial_institution_statement_accounts",
				"financial_institution_statement_payments", "financial_institution_statements",
				"financial_institutions", "financial_object_status", "financial_object_status_category_types",
				"financial_object_status_details", "financial_object_status_types", "financial_posting_rollup_batches",
				"financial_posting_rollups", "financial_postings_stage", "global_financial_postings", "legal_entities",
				"local_financial_postings", "mapping_cas_bds_pymt_app", "multi_ledger_revenue_recognition_charges",
				"operating_countries", "pay_terms_config", "payment_attributes",
				"payment_clearing_account_posting_config", "payment_detail_distribution", "payment_detail_status",
				"payment_details", "payment_entity_account_posting_config", "payment_mode_attributes",
				"payment_mode_attributes_config", "payment_mode_config", "payment_mode_limit_config", "payment_modes",
				"payment_status", "payment_status_config", "payments", "phone_numbers", "postings_period_config",
				"preference_categories", "preferences", "project_rollout_details", "project_rollouts",
				"promotion_charge_type_mapping", "reason_codes", "reclassification_charges_config",
				"reconciliation_config", "reconciliation_details", "reconciliation_discrepancies",
				"reconciliation_items", "reconciliation_rules", "reconciliation_types", "reconciliations",
				"sequence_data", "service_classifications", "subscribed_dp_events", "tax_engine_organization_config",
				"tax_posting_config", "taxes", "tmp_charges_staging", "to_be_dropped_bfsm_copart_financial_hierarchy",
				"to_be_dropped_bfsm_financial_legal_entities", "tobedrop_eeph2_business_entity_snapshot",
				"tobedrop_eeph2_client_event_transaction_logs", "tobedrop_eeph2_event_attributes_config",
				"tobedrop_eeph2_financial_action_history", "tobedrop_eeph2_financial_attributes",
				"tobedrop_eeph2_financial_event_categories", "tobedrop_eeph2_financial_event_history",
				"tobedrop_eeph2_financial_party_type_config", "tobedrop_event_category_types", "tobedrop_event_details",
				"tobedrop_event_types", "tobedrop_event_types_category_config", "tobedrop_events",
				"tobedrop_financial_event_bill_type_config", "tobedrop_financial_event_integration_flow_config",
				"tobedrop_payment_adjustment_reasons", "tobedrop_payment_attributes_stage",
				"tobedrop_payment_detail_distribution_stage", "tobedrop_payment_details_stage",
				"tobedrop_payment_mode_override_reasons", "tobedrop_payment_status_stage", "tobedrop_payments_stage",
				"tobedrop_payout_transaction_details", "tobedrop_payout_transactions", "transaction_comments_config",
				"unapplied_funds_cas_copy", "validation_details", "validation_rules_config", "vat_rate_config",
				"workflow_event_logs");

		List<String> qa4 = Arrays.asList("DATABASECHANGELOG", "DATABASECHANGELOGLOCK", "addresses",
				"application_messages", "bill_entity_account_posting_config", "bill_types", "business_entity_snapshot",
				"charge_type_financial_posting_config", "charge_types", "charges_staging", "check_details",
				"check_sequence_data", "check_types", "check_verification_provider_config", "client_event_request_logs",
				"client_event_transaction_logs", "client_events", "client_to_financial_event_mapping",
				"communication_types", "communications", "config_staging", "copart_financial_hierarchy",
				"copart_fiscal_year_config", "copart_ops_hierarchy", "countries", "dimension_attributes_config",
				"dimension_attributes_data_map", "dimension_config", "dimension_data", "dimension_nav_map",
				"document_associations", "document_delivery", "document_delivery_email_config",
				"document_delivery_type_config", "document_delivery_types", "document_templates", "document_types",
				"documents", "dp_to_client_event_mapping", "electronics", "email_template_subject_config",
				"email_templates", "entity_communication_preferences", "entity_types", "error_logs",
				"event_attributes_config", "event_category_types", "event_details", "event_template_attributes",
				"event_templates", "event_types", "event_types_category_config", "events",
				"external_tax_bill_attributes", "external_tax_bill_details", "external_tax_bills",
				"external_tax_mapping", "file_formats", "financial_account_transaction_details",
				"financial_account_transaction_discrepancies", "financial_accounts", "financial_action_history",
				"financial_attributes", "financial_entity_payment_mode_attributes_config",
				"financial_event_bill_type_config", "financial_event_categories", "financial_event_generation_config",
				"financial_event_history", "financial_event_integration_flow_config", "financial_event_request_logs",
				"financial_events", "financial_institution_account_app_association", "financial_institution_accounts",
				"financial_institution_branches", "financial_institution_file_formats",
				"financial_institution_file_transaction_codes", "financial_institution_statement_accounts",
				"financial_institution_statement_payments", "financial_institution_statements",
				"financial_institutions", "financial_party_type_config", "financial_posting_rollup_batches",
				"financial_posting_rollups", "financial_postings_stage", "global_financial_postings", "legal_entities",
				"local_financial_postings", "mapping_cas_bds_pymt_app", "operating_countries",
				"payment_adjustment_reasons", "payment_attributes", "payment_attributes_stage",
				"payment_clearing_account_posting_config", "payment_detail_distribution",
				"payment_detail_distribution_stage", "payment_detail_status", "payment_details",
				"payment_details_stage", "payment_entity_account_posting_config", "payment_mode_attributes",
				"payment_mode_attributes_config", "payment_mode_config", "payment_mode_limit_config",
				"payment_mode_override_reasons", "payment_modes", "payment_status", "payment_status_config",
				"payment_status_stage", "payments", "payments_stage", "payout_transaction_details",
				"payout_transactions", "phone_numbers", "postings_period_config", "preference_categories",
				"preferences", "project_rollout_details", "project_rollouts", "reconciliation_config",
				"reconciliation_details", "reconciliation_discrepancies", "reconciliation_items",
				"reconciliation_rules", "reconciliation_types", "reconciliations", "service_classifications",
				"subscribed_dp_events", "tax_engine_organization_config", "tax_posting_config",
				"to_be_dropped_bfsm_copart_financial_hierarchy", "to_be_dropped_bfsm_financial_legal_entities",
				"unapplied_funds_cas_copy", "validation_details", "validation_rules_config", "workflow_event_logs");

		Set<String> qaSet = new HashSet<>(qa4);

		for (String lot : dev4) {
			if (!qaSet.contains(lot)) {
				System.out.println(lot);
			}
		}
	}

}
