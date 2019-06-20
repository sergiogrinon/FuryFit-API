package com.furyfit.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("macrocalculator")
public class MacroCalculator_Service {

	@GET
	@Path("calculateusermacros/{sex}/{age}/{uweight}/{uheight}/{uactivity}/{uobjective}")
	@Produces("application/json")
	public Response getUserMacros(@PathParam("sex") String sex, @PathParam("age") int age,
			@PathParam("uweight") float uweight, @PathParam("uheight") float uheight,
			@PathParam("uactivity") String uactivity, @PathParam("uobjective") String uobjective) {
		int macroCalcResponse;
		macroCalcResponse = calculateMacros(sex, age, uweight, uheight, uactivity, uobjective);
		return Response.ok(macroCalcResponse).header("Access-Control-Allow-Origin", "*").build();
	}

	// Male Activity Index (constants)
	static double maleLightActivity = 1.55;
	static double maleMedActivity = 1.78;
	static double maleHighActivity = 2.10;

	// Female Activity Index (constants)
	static double femaleLightActivity = 1.56;
	static double femaleMedActivity = 1.64;
	static double femaleHighActivity = 1.82;

	private static int calculateMacros(String userSex, int userAge, float userWeight, float userHeight,
			String userActivity, String userObjective) {

		double userTMB;
		int userMaintenanceCalories; // Depends on the activityIndex
		int userDailyCalorieCount;

		if (userSex.equals("Mujer")) {
			userTMB = calculateFemaleTMB(userAge, userWeight, userHeight);
			userMaintenanceCalories = calculateFemaleDailyCalories(userTMB, userActivity);
			userDailyCalorieCount = calculateTotalFemaleCalorieCount(userMaintenanceCalories, userObjective);

		} else {
			userTMB = calculateMaleTMB(userAge, userWeight, userHeight);
			userMaintenanceCalories = calculateMaleDailyCalories(userTMB, userActivity);
			userDailyCalorieCount = calculateTotalMaleCalorieCount(userMaintenanceCalories, userObjective);
		}

		return userDailyCalorieCount;

	}

	static double calculateMaleTMB(int edadH, float pesoH, float alturaH) {
		double maleTMB;
		maleTMB = 66.43 + ((13.751 * pesoH) + (5.0033 * alturaH) - (6.55 * edadH));
		return maleTMB;
	}

	static double calculateFemaleTMB(int edadM, float pesoM, float alturaM) {
		double femaleTMB;
		femaleTMB = 655.1 + ((9.463 * pesoM) + (1.83 * alturaM) - (4.6756 * edadM));
		return femaleTMB;
	}

	static int calculateMaleDailyCalories(double maleUserTMB, String maleUserActivityIndex) {
		int maleDailyCalories = 0;
		switch (maleUserActivityIndex) {
		case "Ligero":
			maleDailyCalories = (int) (maleUserTMB * maleLightActivity);
			break;
		case "Moderado":
			maleDailyCalories = (int) (maleUserTMB * maleMedActivity);
			break;
		case "Intenso":
			maleDailyCalories = (int) (maleUserTMB * maleHighActivity);
			break;
		}
		return maleDailyCalories;
	}

	static int calculateFemaleDailyCalories(double femaleUserTMB, String femaleUserActivityIndex) {
		int femaleDailyCalories = 0;
		switch (femaleUserActivityIndex) {
		case "Ligero":
			femaleDailyCalories = (int) (femaleUserTMB * femaleLightActivity);
			break;
		case "Moderado":
			femaleDailyCalories = (int) (femaleUserTMB * femaleMedActivity);
			break;
		case "Intenso":
			femaleDailyCalories = (int) (femaleUserTMB * femaleHighActivity);
			break;
		}
		return femaleDailyCalories;
	}

	// Finally have to calculate the total daily calorie count depending on the
	// objective
	static int calculateTotalFemaleCalorieCount(int maintenanceCalories, String femaleObjective) {
		int femaleTotalCalCount = maintenanceCalories;
		switch (femaleObjective) {
		case "Vol":
			femaleTotalCalCount = (int) (maintenanceCalories * 1.10);
			break;
		case "Defi":
			femaleTotalCalCount = (int) (maintenanceCalories / 1.10);
			break;
		}
		return femaleTotalCalCount;
	}

	static int calculateTotalMaleCalorieCount(int maintenanceCalories, String maleObjective) {
		int maleTotalCalCount = maintenanceCalories;
		switch (maleObjective) {
		case "Vol":
			maleTotalCalCount = (int) (maintenanceCalories * 1.10);
			break;
		case "Defi":
			maleTotalCalCount = (int) (maintenanceCalories / 1.20);
			break;
		}
		return maleTotalCalCount;
	}

}
