package mindustry.content;

import arc.struct.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.TechTree.*;

public class ErekirTechTree{

    public static void load(){
        //TODO might be unnecessary with no asteroids
        Seq<Objective> erekirSector = Seq.with(new OnPlanet(Planets.erekir));

        var costMultipliers = new ObjectFloatMap<Item>();
        costMultipliers.put(Items.silicon, 8);
        costMultipliers.put(Items.surgeAlloy, 4);
        costMultipliers.put(Items.phaseFabric, 4);
        costMultipliers.put(Items.thorium, 9);
        costMultipliers.put(Items.graphite, 9);

        //TODO gate behind capture

        Planets.erekir.techTree = nodeRoot("erekir", coreBastion, true, () -> {
            context().researchCostMultipliers = costMultipliers;

            node(duct, erekirSector, () -> {
                node(ductRouter, () -> {
                    node(ductBridge, () -> {
                        node(surgeConveyor, () -> {
                            node(surgeRouter);
                        });

                        node(unitCargoLoader, () -> {
                            node(unitCargoUnloadPoint, () -> {

                            });
                        });
                    });

                    node(overflowDuct, () -> {
                        node(ductUnloader, () -> {

                        });
                    });

                    node(reinforcedContainer, () -> {
                        node(reinforcedVault, () -> {

                        });
                    });
                });

                //TODO further in? no use for these without units.
                node(constructor, Seq.with(new Research(siliconArcFurnace), erekirSector.first()), () -> {
                    node(payloadLoader, () -> {
                        node(payloadUnloader, () -> {
                            node(payloadPropulsionTower, () -> {

                            });
                        });
                    });

                    node(smallDeconstructor, () -> {
                        node(largeConstructor, () -> {

                        });

                        node(deconstructor, () -> {

                        });
                    });
                });
            });

            //TODO move into turbine condenser?
            node(plasmaBore, () -> {
                node(impactDrill, Seq.with(new OnSector(aware)), () -> {
                    node(largePlasmaBore, () -> {
                        node(eruptionDrill, () -> {

                        });
                    });
                });
            });

            node(turbineCondenser, () -> {
                node(beamNode, () -> {
                    node(ventCondenser, Seq.with(new OnSector(aware)), () -> {
                        node(chemicalCombustionChamber, () -> {
                            node(pyrolysisGenerator, () -> {

                            });
                        });
                    });

                    node(beamTower, () -> {

                    });


                    node(regenProjector, () -> {
                        //TODO more tiers of build tower or "support" structures like overdrive projectors
                        node(buildTower, () -> {

                        });
                    });
                });

                node(reinforcedConduit, () -> {
                    //TODO so should this be *on* or *complete*?
                    node(reinforcedPump, Seq.with(new SectorComplete(aware)), () -> {
                        //TODO T2 pump
                    });

                    node(reinforcedLiquidJunction, () -> {
                        node(reinforcedBridgeConduit, () -> {

                        });

                        node(reinforcedLiquidRouter, () -> {
                            node(reinforcedLiquidContainer, () -> {
                                node(reinforcedLiquidTank, () -> {

                                });
                            });
                        });
                    });
                });

                node(siliconArcFurnace, () -> {
                    node(cliffCrusher, () -> {
                        node(electrolyzer, () -> {
                            node(oxidationChamber, () -> {
                                node(electricHeater, () -> {
                                    node(heatRedirector, () -> {

                                    });

                                    node(atmosphericConcentrator, () -> {
                                        node(cyanogenSynthesizer, () -> {

                                        });
                                    });

                                    node(carbideCrucible, () -> {
                                        node(surgeCrucible, () -> {
                                            node(phaseSynthesizer, () -> {
                                                node(phaseHeater, () -> {

                                                });
                                            });
                                        });
                                    });
                                });
                            });

                            node(slagIncinerator, () -> {

                                node(slagCentrifuge, () -> {

                                });

                                node(heatReactor, () -> {

                                });
                            });
                        });
                    });
                });
            });

            node(breach, Seq.with(new Research(siliconArcFurnace)), () -> {
                node(berylliumWall, () -> {
                    node(berylliumWallLarge, () -> {

                    });

                    node(tungstenWall, () -> {
                        node(tungstenWallLarge, () -> {

                        });
                    });
                });


                node(sublimate, () -> {
                    //TODO implement
                    node(titan, () -> {

                    });
                });
            });

            node(coreCitadel, () -> {
                node(coreAcropolis, () -> {

                });
            });

            //TODO more sectors
            node(onset, () -> {
                node(aware, Seq.with(new SectorComplete(onset), new Research(ductRouter)), () -> {

                });
            });

            nodeProduce(Items.beryllium, () -> {
                nodeProduce(Items.oxide, () -> {
                    nodeProduce(Items.fissileMatter, () -> {

                    });
                });

                nodeProduce(Liquids.ozone, () -> {
                    nodeProduce(Liquids.hydrogen, () -> {
                        nodeProduce(Liquids.nitrogen, () -> {
                            nodeProduce(Liquids.cyanogen, () -> {

                            });
                        });
                    });
                });

                nodeProduce(Items.tungsten, () -> {
                    nodeProduce(Items.carbide, () -> {
                        nodeProduce(Liquids.gallium, () -> {

                        });
                    });
                });
            });
        });
    }
}
