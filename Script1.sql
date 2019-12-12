--<ScriptOptions statementTerminator=";"/>

DROP TABLE comp;

CREATE TABLE comp (
	ID INT NOT NULL,
	NAME VARCHAR(50),
	CASnumber VARCHAR(50),
	COMPTYPE VARCHAR(50),
	COMPINDEX INT,
	FORMULA VARCHAR(50),
	MOLARMASS DOUBLE,
	LIQDENS DOUBLE,
	TC DOUBLE,
	PC DOUBLE,
	ACSFACT DOUBLE,
	NORMBOIL DOUBLE,
	MWAVG DOUBLE,
	CRITVOL DOUBLE,
	PVMODEL VARCHAR(255) DEFAULT 0,
	Href DOUBLE DEFAULT 0,
	CPA DOUBLE,
	CPB DOUBLE,
	CPC DOUBLE,
	CPD DOUBLE,
	CPE DOUBLE,
	AntoineVapPresLiqType VARCHAR(50),
	ANTOINEA DOUBLE,
	ANTOINEB DOUBLE,
	ANTOINEC DOUBLE,
	ANTOINED DOUBLE,
	ANTOINEE DOUBLE DEFAULT 0,
	DIPOLEMOMENT DOUBLE,
	VISCFACT DOUBLE,
	RACKETZ DOUBLE,
	volcorrSRK_T DOUBLE DEFAULT 0,
	LJDIAMETER DOUBLE,
	LJEPS DOUBLE,
	SphericalCoreRadius DOUBLE DEFAULT 0,
	LIQVISCMODEL INT,
	LIQVISC1 DOUBLE,
	LIQVISC2 DOUBLE,
	LIQVISC3 DOUBLE,
	LIQVISC4 DOUBLE,
	GIBBSENERGYOFFORMATION DOUBLE,
	DIELECTRICPARAMETER1 DOUBLE,
	DIELECTRICPARAMETER2 DOUBLE,
	DIELECTRICPARAMETER3 DOUBLE,
	DIELECTRICPARAMETER4 DOUBLE,
	DIELECTRICPARAMETER5 DOUBLE,
	IONICCHARGE INT,
	REFERENCESTATETYPE VARCHAR(255),
	HenryCoef1 DOUBLE,
	HenryCoef2 DOUBLE DEFAULT 0,
	HenryCoef3 DOUBLE,
	HenryCoef4 DOUBLE DEFAULT 0,
	SCHWARTZENTRUBER1 DOUBLE,
	SCHWARTZENTRUBER2 DOUBLE,
	SCHWARTZENTRUBER3 DOUBLE,
	LIQUIDCONDUCTIVITY1 DOUBLE,
	LIQUIDCONDUCTIVITY2 DOUBLE,
	LIQUIDCONDUCTIVITY3 DOUBLE,
	PARACHOR DOUBLE,
	HEATOFFUSION DOUBLE,
	TRIPLEPOINTDENSITY DOUBLE,
	TRIPLEPOINTPRESSURE DOUBLE,
	TRIPLEPOINTTEMPERATURE DOUBLE,
	MELTINGPOINTTEMPERATURE DOUBLE,
	ENTHALPYOFFORMATION DOUBLE,
	ABSOLUTEENTROPY DOUBLE,
	SOLIDDENSITYCOEFS1 DOUBLE,
	SOLIDDENSITYCOEFS2 DOUBLE,
	SOLIDDENSITYCOEFS3 DOUBLE,
	SOLIDDENSITYCOEFS4 DOUBLE,
	SOLIDDENSITYCOEFS5 DOUBLE,
	LIQUIDDENSITYCOEFS1 DOUBLE,
	LIQUIDDENSITYCOEFS2 DOUBLE,
	LIQUIDDENSITYCOEFS3 DOUBLE,
	LIQUIDDENSITYCOEFS4 DOUBLE,
	LIQUIDDENSITYCOEFS5 DOUBLE,
	HEATOFVAPORIZATIONCOEFS1 DOUBLE,
	HEATOFVAPORIZATIONCOEFS2 DOUBLE,
	HEATOFVAPORIZATIONCOEFS3 DOUBLE,
	HEATOFVAPORIZATIONCOEFS4 DOUBLE,
	HEATOFVAPORIZATIONCOEFS5 DOUBLE,
	STDDENS DOUBLE,
	MC1 DOUBLE,
	MC2 DOUBLE,
	MC3 DOUBLE,
	MC1Solid DOUBLE,
	MC2Solid DOUBLE,
	MC3Solid DOUBLE,
	TwuCoon1 DOUBLE DEFAULT 0,
	TwuCoon2 DOUBLE DEFAULT 0,
	TwuCoon3 DOUBLE DEFAULT 0,
	associationsites INT DEFAULT 0,
	associationscheme VARCHAR(50),
	racketZCPA DOUBLE DEFAULT 0,
	volcorrCPA_T DOUBLE DEFAULT 0,
	associationboundingvolume_SRK DOUBLE DEFAULT 0,
	associationenergy DOUBLE DEFAULT 0,
	aCPA_SRK DOUBLE DEFAULT 0,
	bCPA_SRK DOUBLE DEFAULT 0,
	mCPA_SRK DOUBLE DEFAULT 0,
	aCPA_PR DOUBLE,
	bCPA_PR DOUBLE,
	mCPA_PR DOUBLE,
	associationboundingvolume_PR DOUBLE,
	calcActivity INT DEFAULT 1,
	ANTOINESolidA DOUBLE DEFAULT 0,
	ANTOINESolidB DOUBLE,
	ANTOINESolidC DOUBLE DEFAULT 0,
	Hsub INT DEFAULT 0,
	criticalViscosity DOUBLE,
	HydrateA1Small DOUBLE DEFAULT 0,
	HydrateB1Small DOUBLE DEFAULT 0,
	HydrateA1Large DOUBLE DEFAULT 0,
	HydrateB1Large DOUBLE DEFAULT 0,
	HydrateA2Small DOUBLE DEFAULT 0,
	HydrateB2Small DOUBLE DEFAULT 0,
	HydrateA2Large DOUBLE DEFAULT 0,
	HydrateB2Large DOUBLE DEFAULT 0,
	HydrateFormer VARCHAR(50),
	mSAFT DOUBLE DEFAULT 0,
	sigmaSAFT DOUBLE DEFAULT 0,
	epsikSAFT DOUBLE DEFAULT 0,
	associationboundingvolume_PCSAFT DOUBLE DEFAULT 0,
	associationenergy_PCSAFT DOUBLE DEFAULT 0,
	LJDIAMETERHYDRATE DOUBLE,
	LJEPSHYDRATE DOUBLE,
	SphericalCoreRadiusHYDRATE DOUBLE DEFAULT 0,
	DeshMatIonicDiameter DOUBLE DEFAULT 0,
	waxformer INT DEFAULT 0,
	B2_largeGF DOUBLE DEFAULT 0,
	A1_smallGF DOUBLE DEFAULT 0,
	B1_smallGF DOUBLE DEFAULT 0,
	A1_largeGF DOUBLE DEFAULT 0,
	B1_largeGF DOUBLE DEFAULT 0,
	A2_smallGF DOUBLE DEFAULT 0,
	B2_smallGF DOUBLE DEFAULT 0,
	A2_largeGF DOUBLE DEFAULT 0,
	CPsolid1 DOUBLE DEFAULT 0,
	CPsolid2 DOUBLE DEFAULT 0,
	CPsolid3 DOUBLE DEFAULT 0,
	CPsolid4 DOUBLE DEFAULT 0,
	CPsolid5 DOUBLE DEFAULT 0,
	CPliquid1 DOUBLE DEFAULT 0,
	CPliquid2 DOUBLE DEFAULT 0,
	CPliquid3 DOUBLE DEFAULT 0,
	CPliquid4 DOUBLE DEFAULT 0,
	CPliquid5 DOUBLE DEFAULT 0,
	MCPR1 DOUBLE DEFAULT 0,
	MCPR2 DOUBLE DEFAULT 0,
	MCPR3 DOUBLE DEFAULT 0,
	PARACHOR_CPA DOUBLE DEFAULT 0
) ENGINE=MyISAM;
