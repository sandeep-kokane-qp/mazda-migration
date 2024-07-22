package com.boot.migration.utility;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.boot.entity.qp.Answer;
import com.boot.entity.qp.Question;

public class ExcelUtility {

	static String[] QUESTION_HEADERS = { "id", "survey_id", "ord_num", "q_text", "orientation", "max_answers",
			"min_answers", "random", "ties_allowed", "force_all", "section_id", "branch", "q_desc", "other", "required",
			"branch_out", "public_result", "random_section", "type", "subtype", "show_tip", "tip_link_text",
			"question_tip_id", "exact_min_answers", "answer_width", "width", "font_info", "answer_font_info",
			"enable_multiple_branch", "desc_font_info", "desc_width", "extraction_source_id", "extraction", "code",
			"tip_header", "display_options", "copy_source_id", "page_break", "skip_numbering", "subsection_numbering",
			"constant_multiplier", "numbering_location", "num_tasks", "additional_info_id", "matrix_extraction_list",
			"matrix_extraction_source", "weight", "enable_custom_scale", "data_prepopulation_mode",
			"custom_validator_class", "custom_validator_argument", "enable_ad_hoc", "question_separator",
			"enable_dynamic_replacement", "calculation_mode", "chart_type", "standard_profile_id", "question_group",
			"survey_part_id", "canvas_app_id", "create_ts", "update_ts", "cultural_marker_id", "metadata_scale_type",
			"report_label", "building_block_id", "measure_id", "created_by_actor_id", "updated_by_actor_id", "draft_id",
			"group_id" };

	static String[] ANSWER_HEADERS = { "id", "survey_id", "ord_num", "other", "extraction_source_id", "code",
			"matrix_extraction_source", "create_ts", "update_ts", "created_by_actor_id", "updated_by_actor_id",
			"draft_id", "q_id", "a_text", "text_box", "branch_id", "comp_id", "comp_value", "enable_quota", "quota",
			"quota_branch_id", "piping_text", "exclusive_option", "size", "exclude_randomize", "location",
			"enable_mean_calculation", "cost_index", "answer_code", "height", "scale", "chain_survey_id", "suffix",
			"is_default", "report_text", "attached_custom_var", "standard_profile_option_id", "generic_settings_json",
			"answer_group_id" };

	public static List<Question> excelQuestionsToList(InputStream inputStream) {
		try {
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet questionSheet = workbook.getSheet("Query result");
			Iterator<Row> rows = questionSheet.iterator();
			List<Question> questionList = new ArrayList<>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();
				Question question = new Question();
				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					switch (cellIdx) {
					case 0:
						question.setId((int) currentCell.getNumericCellValue());
						break;
					case 1:
						question.setSurveyId((int) currentCell.getNumericCellValue());
						break;
					case 2:
						question.setOrdNum((int) currentCell.getNumericCellValue());
						break;
					case 3:
						question.setQText(currentCell.getStringCellValue());
						break;
					case 4:
						question.setOrientation((int) currentCell.getNumericCellValue());
						break;
					case 5:
						question.setMaxAnswers(currentCell.getNumericCellValue());
						break;
					case 6:
						question.setMinAnswers(currentCell.getNumericCellValue());
						break;
					case 7:
						question.setRandom(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 8:
						question.setTiesAllowed(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 9:
						question.setForceAll(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 10:
						question.setSectionId((int) currentCell.getNumericCellValue());
						break;
					case 11:
						question.setBranch(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 12:
						question.setQDesc(currentCell.getStringCellValue());
						break;
					case 13:
						question.setOther(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 14:
						question.setRequired(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 15:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setBranchOut((int) currentCell.getNumericCellValue());
						}
						break;
					case 16:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setPublicResult(currentCell.getNumericCellValue() == 0 ? false : true);
						}
						break;
					case 17:
						question.setRandomSection(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 18:
						question.setType(currentCell.getStringCellValue());
						break;
					case 19:
						question.setSubtype(currentCell.getStringCellValue().charAt(0));
						break;
					case 20:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setShowTip((int) currentCell.getNumericCellValue());
						}
						break;
					case 21:
						question.setTipLinkText(currentCell.getStringCellValue());
						break;
					case 22:
						question.setQuestionTipId((int) currentCell.getNumericCellValue());
						break;
					case 23:
						question.setExactMinAnswers(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 24:
						question.setAnswerWidth(currentCell.getStringCellValue());
						break;
					case 25:
						question.setWidth(currentCell.getStringCellValue());
						break;
					case 26:
						question.setFontInfo(currentCell.getStringCellValue());
						break;
					case 27:
						question.setAnswerFontInfo(currentCell.getStringCellValue());
						break;
					case 28:
						question.setEnableMultipleBranch(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 29:
						question.setDescFontInfo(currentCell.getStringCellValue());
						break;
					case 30:
						question.setDescWidth(currentCell.getStringCellValue());
						break;
					case 31:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setExtractionSourceId((int) currentCell.getNumericCellValue());
						}
						break;
					case 32:
						question.setExtraction(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 33:
						question.setCode(currentCell.getStringCellValue());
						break;
					case 34:
						question.setTipHeader(currentCell.getStringCellValue());
						break;
					case 35:
						question.setDisplayOptions((int) currentCell.getNumericCellValue());
						break;
					case 36:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setCopySourceId((int) currentCell.getNumericCellValue());
						}
						break;
					case 37:
						question.setPageBreak(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 38:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setSkipNumbering(currentCell.getNumericCellValue() == 0 ? false : true);
						}
						break;
					case 39:
						question.setSubsectionNumbering(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 40:
						question.setConstantMultiplier((float) currentCell.getNumericCellValue());
						break;
					case 41:
						question.setNumberingLocation((short) currentCell.getNumericCellValue());
						break;
					case 42:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setNumTasks((int) currentCell.getNumericCellValue());
						}
						break;
					case 43:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setAdditionalInfoId((int) currentCell.getNumericCellValue());
						}
						break;
					case 44:
						question.setMatrixExtractionList(currentCell.getStringCellValue());
						break;
					case 45:
						question.setMatrixExtractionSource(currentCell.getStringCellValue());
						break;
					case 46:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setWeight((float) currentCell.getNumericCellValue());
						}
						break;
					case 47:
						question.setEnableCustomScale(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 48:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setDataPrepopulationMode((int) currentCell.getNumericCellValue());
						}
						break;
					case 49:
						question.setCustomValidatorClass(currentCell.getStringCellValue());
						break;
					case 50:
						question.setCustomValidatorArgument(currentCell.getStringCellValue());
						break;
					case 51:
						question.setEnableAdHoc(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 52:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setQuestionSeparator(currentCell.getNumericCellValue() == 0 ? false : true);
						}
						break;
					case 53:
						question.setEnableDynamicReplacement(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 54:
						question.setCalculationMode((int) currentCell.getNumericCellValue());
						break;
					case 55:
						question.setChartType((int) currentCell.getNumericCellValue());
						break;
					case 56:
						question.setStandardProfileId((int) currentCell.getNumericCellValue());
						break;
					case 57:
						question.setQuestionGroup(currentCell.getStringCellValue());
						break;
					case 58:
						question.setSurveyPartId((int) currentCell.getNumericCellValue());
						break;
					case 59:
						question.setCanvasAppId((int) currentCell.getNumericCellValue());
						break;
					case 60:
						question.setCreateTs(currentCell.getLocalDateTimeCellValue());
						break;
					case 61:
						question.setUpdateTs(currentCell.getLocalDateTimeCellValue());
						break;
					case 62:
						question.setCulturalMarkerId((int) currentCell.getNumericCellValue());
						break;
					case 63:
						question.setMetadataScaleType((byte) currentCell.getNumericCellValue());
						break;
					case 64:
						question.setReportLabel(currentCell.getStringCellValue());
						break;
					case 65:
						question.setBuildingBlockId((int) currentCell.getNumericCellValue());
						break;
					case 66:
						question.setMeasureId((int) currentCell.getNumericCellValue());
						break;
					case 67:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setCreatedByActorId((int) currentCell.getNumericCellValue());
						}
						break;
					case 68:
						if (currentCell.getCellType() != CellType.BLANK) {
							question.setUpdatedByActorId((int) currentCell.getNumericCellValue());
						}
						break;
					case 69:
						question.setDraftId(currentCell.getStringCellValue());
						break;
					case 70:
						question.setGroupId(currentCell.getStringCellValue());
						break;
					default:
						break;
					}
					cellIdx++;
				}
				questionList.add(question);
			}
			workbook.close();
			return questionList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

	public static List<Answer> excelAnswersToList(InputStream inputStream) {
		try {
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet questionSheet = workbook.getSheet("Query result");
			Iterator<Row> rows = questionSheet.iterator();
			List<Answer> answerList = new ArrayList<>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();
				Answer answer = new Answer();
				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					switch (cellIdx) {
					case 0:
						answer.setId((int) currentCell.getNumericCellValue());
						break;
					case 1:
						answer.setQId((int) currentCell.getNumericCellValue());
						break;
					case 2:
						answer.setOrdNum((int) currentCell.getNumericCellValue());
						break;
					case 3:
						answer.setAText(currentCell.getStringCellValue());
						break;
					case 4:
						answer.setTextBox((int) currentCell.getNumericCellValue());
						break;
					case 5:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setBranchId((int) currentCell.getNumericCellValue());
						}
						break;
					case 6:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setCompId((int) currentCell.getNumericCellValue());
						}
						break;
					case 7:
						answer.setCompValue((int) currentCell.getNumericCellValue());
						break;
					case 8:
						answer.setOther(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 9:
						answer.setSurveyId((int) currentCell.getNumericCellValue());
						break;
					case 10:
						answer.setEnableQuota(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 11:
						answer.setQuota((int) currentCell.getNumericCellValue());
						break;
					case 12:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setQuotaBranchId((int) currentCell.getNumericCellValue());
						}
						break;
					case 13:
						answer.setPipingText(currentCell.getStringCellValue());
						break;
					case 14:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setExtractionSourceId((int) currentCell.getNumericCellValue());
						}
						break;
					case 15:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setExclusiveOption(currentCell.getNumericCellValue() == 0 ? false : true);
						}
						break;
					case 16:
						answer.setCode(currentCell.getStringCellValue());
						break;
					case 17:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setSize((int) currentCell.getNumericCellValue());
						}
						break;
					case 18:
						answer.setExcludeRandomize(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 19:
						answer.setLocation((short) currentCell.getNumericCellValue());
						break;
					case 20:
						answer.setEnableMeanCalculation(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 21:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setCostIndex((float) currentCell.getNumericCellValue());
						}
						break;
					case 22:
						answer.setMatrixExtractionSource(currentCell.getStringCellValue());
						break;
					case 23:
						answer.setAnswerCode(currentCell.getStringCellValue());
						break;
					case 24:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setHeight((int) currentCell.getNumericCellValue());
						}
						break;
					case 25:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setScale((float) currentCell.getNumericCellValue());
						}
						break;
					case 26:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setChainSurveyId((int) currentCell.getNumericCellValue());
						}
						break;
					case 27:
						answer.setSuffix(currentCell.getStringCellValue());
						break;
					case 28:
						answer.setDefault(currentCell.getNumericCellValue() == 0 ? false : true);
						break;
					case 29:
						answer.setReportText(currentCell.getStringCellValue());
						break;
					case 30:
						answer.setAttachedCustomVar((int) currentCell.getNumericCellValue());
						break;
					case 31:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setStandardProfileOptionId((int) currentCell.getNumericCellValue());
						}
						break;
					case 32:
						answer.setCreateTs(currentCell.getLocalDateTimeCellValue());
						break;
					case 33:
						answer.setUpdateTs(currentCell.getLocalDateTimeCellValue());
						break;
					case 34:
						answer.setGenericSettingsJson(currentCell.getStringCellValue());
						break;
					case 35:
						answer.setAnswerGroupId((int) currentCell.getNumericCellValue());
						break;
					case 36:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setCreatedByActorId((int) currentCell.getNumericCellValue());
						}
						break;
					case 37:
						if (currentCell.getCellType() != CellType.BLANK) {
							answer.setUpdatedByActorId((int) currentCell.getNumericCellValue());
						}
						break;
					case 38:
						answer.setDraftId(currentCell.getStringCellValue());
						break;
					default:
						break;
					}
					cellIdx++;
				}
				answerList.add(answer);
			}
			workbook.close();
			return answerList;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}
