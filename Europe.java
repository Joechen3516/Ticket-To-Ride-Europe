import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Europe {
	private ArrayList<City> cities;

	public Europe() {
		cities = new ArrayList<>();
		createDefaultCities();
	}

		public void addEdge(City a, City b, int length, int ferry, TrainColor c,double[] xs,double[] ys,double[] as) {
		a.getRoads().add(new Road(b, a, length, ferry,c, xs,ys,as));
		b.getRoads().add(new Road(a, b, length, ferry,c, xs,ys,as));
	}
	public void addEdge(City a, City b, int length, int ferry, TrainColor c, Boolean m, double[] xs,double[] ys,double[] as) {
		a.getRoads().add(new Road(b, a, length, ferry,c, m, xs,ys,as));
		b.getRoads().add(new Road(a, b, length, ferry,c, m, xs,ys,as));
	}

	public boolean addCity(City c) {
		return cities.add(c);
	}


/** needs reworking
	public void printGraph(HashSet<City> x) {
		for (City y:x) {
			ArrayList<Road> roads = y.getRoads();
			System.out.println("\nVertex " + y.getName() + ":");
			for (Road z : roads) {
				System.out.print(" -> " + z.getOtherNode().getName());
			}
			System.out.println();
		}
	}
**/

	public void createDefaultCities() {

		addCity(new City("Edinburgh")); //done
		addCity(new City("London")); //done
		addCity(new City("Amsterdam")); //done
		addCity(new City("Essen")); //done
		addCity(new City("Berlin")); //done
		addCity(new City("Kobenhavn")); //done
		addCity(new City("Stockholm")); //done
		addCity(new City("Petrograd")); //done
		addCity(new City("Moskova")); //done
		addCity(new City("Smolensk")); //done
		addCity(new City("Wilno")); //done
		addCity(new City("Kyiv")); //done
		addCity(new City("Kharkov")); //done
		addCity(new City("Rostov")); //done
		addCity(new City("Sochi")); //done
		addCity(new City("Erzurum")); //done
		addCity(new City("Ancora")); //done
		addCity(new City("Smyrna")); //done
		addCity(new City("Constantinople")); //done
		addCity(new City("Athina")); //done
		addCity(new City("Palermo")); //done
		addCity(new City("Brindisi")); //done
		addCity(new City("Sofia")); //done
		addCity(new City("Bucuresti")); //done
		addCity(new City("Sevastopol")); //done
		addCity(new City("Warszawa")); //done
		addCity(new City("Danzic")); //done
		addCity(new City("Wien")); //done
		addCity(new City("Zacrad")); //done
		addCity(new City("Venezia")); //done
		addCity(new City("Zurich")); //done
		addCity(new City("Monchen")); //done
		addCity(new City("Frankfurt")); //done
		addCity(new City("Bruxelles")); //done
		addCity(new City("Dieppe")); //done
		addCity(new City("Brest")); //done
		addCity(new City("Paris")); //done
		addCity(new City("Pamplona")); //done
		addCity(new City("Barcelona")); //done
		addCity(new City("Marseille")); //done
		addCity(new City("Roma")); //done
		addCity(new City("Madrid")); //done
		addCity(new City("Lisboa")); //done
		addCity(new City("Cadiz")); //done
		addCity(new City("Sarajevo")); //done
		addCity(new City("Rica")); //done
		addCity(new City("Budapest")); //done


		cities.sort(null);

		addEdge(citySearch("Edinburgh"), citySearch("London"), 4, 0, TrainColor.Black,new double[]{0.1013655462184874,0.11292016806722689,0.12394957983193278,0.13445378151260504},new double[]{0.06051873198847262,0.10758885686839577,0.15369836695485112,0.19980787704130643},new double[]{-0.4350345062237482,-0.42323950932954935,-0.4120965596890702,-0.42323950932954935});
		addEdge(citySearch("Edinburgh"), citySearch("London"), 4, 0, TrainColor.Orange,new double[]{0.11134453781512606,0.12289915966386554,0.1334033613445378,0.14338235294117646},new double[]{0.053794428434197884,0.10182516810758886,0.14793467819404418,0.1930835734870317},new double[]{-0.4144718521340294,-0.3914653655921394,-0.3914653655921394,-0.4144718521340294});
		addEdge(citySearch("London"), citySearch("Amsterdam"), 2, 2, TrainColor.Wild,new double[]{0.16544117647058823,0.19380252100840337},new double[]{0.23439000960614795,0.2372718539865514},new double[]{-1.5092755180838955,-1.5492063392319528});
		addEdge(citySearch("London"), citySearch("Dieppe"), 2, 1, TrainColor.Wild,new double[]{0.14495798319327732,0.14233193277310924},new double[]{0.2564841498559078,0.30643611911623436},new double[]{-6.1984514217013515,-6.17780031313275});
		addEdge(citySearch("London"), citySearch("Dieppe"), 2, 1, TrainColor.Wild,new double[]{0.15546218487394958,0.15283613445378152},new double[]{0.2584053794428434,0.30835734870317005},new double[]{-6.173322062729337,-6.194854314913808}); //yes, there are two of the same route, this is not a mistake
		addEdge(citySearch("Dieppe"), citySearch("Brest"), 2, 0, TrainColor.Orange,new double[]{0.08508403361344538,0.1134453781512605},new double[]{0.3871277617675312,0.35830931796349663},new double[]{-2.151556619349087,-1.6316224832010608});
		addEdge(citySearch("Brest"), citySearch("Paris"), 3, 0, TrainColor.Black,new double[]{0.0898109243697479,0.11659663865546219,0.14548319327731093},new double[]{0.4015369836695485,0.4053794428434198,0.41306436119116235},new double[]{-1.4877516288992325,-1.4520949286382392,-1.4695350207139415});
		addEdge(citySearch("Brest"), citySearch("Pamplona"), 4, 0, TrainColor.Pink,new double[]{0.0861344537815126,0.11186974789915967,0.12657563025210083,0.12920168067226892},new double[]{0.43419788664745435,0.45341018251681076,0.49375600384245916,0.542747358309318},new double[]{-1.2539889734543923,-0.6238923866494361,-0.11155832800069154,-0.019680732434268045});
		addEdge(citySearch("Dieppe"), citySearch("Paris"), 1, 0, TrainColor.Pink,new double[]{0.15441176470588236},new double[]{0.38424591738712777},new double[]{-0.8140992697264302});
		addEdge(citySearch("Dieppe"), citySearch("Bruxelles"), 2, 0, TrainColor.Green,new double[]{0.15808823529411764,0.18119747899159663},new double[]{0.35926993275696445,0.3285302593659942},new double[]{-2.151556619349087,-2.145578893796287});
		addEdge(citySearch("Bruxelles"), citySearch("Paris"), 2, 0, TrainColor.Yellow,new double[]{0.20640756302521007,0.19327731092436976},new double[]{0.3218059558117195,0.36503362151777136},new double[]{-5.780579266786203,-5.790429055303533});
		addEdge(citySearch("Bruxelles"), citySearch("Paris"), 2, 0, TrainColor.Red,new double[]{0.21533613445378152,0.2032563025210084},new double[]{0.33045148895292986,0.37367915465898177},new double[]{-5.808236611754879,-5.762446539343271});
		addEdge(citySearch("Bruxelles"), citySearch("Amsterdam"), 1, 0, TrainColor.Black,new double[]{0.22426470588235295},new double[]{0.2584053794428434},new double[]{-5.876700867304709});
		addEdge(citySearch("Bruxelles"), citySearch("Frankfurt"), 2, 0, TrainColor.Blue,new double[]{0.22111344537815125,0.24894957983193278},new double[]{0.3150816522574448,0.31892411143131605},new double[]{-1.80894678207556,-0.7982972488731552});
		addEdge(citySearch("Amsterdam"), citySearch("Essen"), 3, 0, TrainColor.Yellow,new double[]{0.23319327731092437,0.24317226890756302,0.26733193277310924},new double[]{0.19020172910662825,0.19596541786743515,0.2219020172910663},new double[]{-6.031614032128971,-1.3759921893572973,-0.7093167195937737});
		addEdge(citySearch("Amsterdam"), citySearch("Frankfurt"), 2, 0, TrainColor.White,new double[]{0.23634453781512604,0.25682773109243695},new double[]{0.2728146013448607,0.30547550432276654},new double[]{-0.8140992697264302,-0.7838055098076553});
		addEdge(citySearch("Frankfurt"), citySearch("Paris"), 3, 0, TrainColor.White,new double[]{0.19957983193277312,0.22531512605042017,0.2494747899159664},new double[]{0.41786743515850144,0.4024975984630163,0.37848222862632086},new double[]{-1.8141823363319676,-2.095830944638854,-2.1683789961914104});
		addEdge(citySearch("Frankfurt"), citySearch("Paris"), 3, 0, TrainColor.Orange,new double[]{0.20483193277310924,0.23161764705882354,0.2557773109243697},new double[]{0.43611911623439004,0.4217098943323727,0.39481268011527376},new double[]{-1.8781344171288452,-2.116765909145101,-2.191874461962171});
		addEdge(citySearch("Frankfurt"), citySearch("Monchen"), 2, 0, TrainColor.Pink,new double[]{0.28256302521008403,0.28991596638655465},new double[]{0.37271853986551395,0.4217098943323727},new double[]{-0.2535897370310254,-1.833692055754336});
		addEdge(citySearch("Frankfurt"), citySearch("Berlin"), 3, 0, TrainColor.Black,new double[]{0.2851890756302521,0.3114495798319328,0.33665966386554624},new double[]{0.34197886647454373,0.3208453410182517,0.297790585975024},new double[]{-1.9715247710655441,-1.9958311663319797,-1.9894003868143788});
		addEdge(citySearch("Frankfurt"), citySearch("Berlin"), 3, 0, TrainColor.Red,new double[]{0.29044117647058826,0.31565126050420167,0.34086134453781514},new double[]{0.3573487031700288,0.33525456292026895,0.31412103746397696},new double[]{-1.9958311663319797,-1.9575223913775694,-1.9874280027843325});
		addEdge(citySearch("Frankfurt"), citySearch("Essen"), 2, 0, TrainColor.Green,new double[]{0.28308823529411764,0.29989495798319327},new double[]{0.3275696445725264,0.276657060518732},new double[]{-2.0425597150400185,-0.471763388245122});
		addEdge(citySearch("Essen"), citySearch("Berlin"), 2, 0, TrainColor.Blue,new double[]{0.30987394957983194,0.33718487394957986},new double[]{0.24879923150816521,0.25552353506243997},new double[]{-1.4243911749661644,-1.4695350207139415});
		addEdge(citySearch("Essen"), citySearch("Kobenhavn"), 3, 1, TrainColor.Wild,new double[]{0.28886554621848737,0.30409663865546216,0.32090336134453784},new double[]{0.24111431316042267,0.19596541786743515,0.15561959654178675},new double[]{-2.5576470538560168,-2.488130885694423,-2.52438011057089});
		addEdge(citySearch("Essen"), citySearch("Kobenhavn"), 3, 1, TrainColor.Wild,new double[]{0.2977941176470588,0.31407563025210083,0.33035714285714285},new double[]{0.24975984630163303,0.20653218059558118,0.16522574447646493},new double[]{-2.5292740356107917,-2.509598578526493,-2.509598578526493});
		addEdge(citySearch("Kobenhavn"), citySearch("Stockholm"), 3, 0, TrainColor.Yellow,new double[]{0.3471638655462185,0.36764705882352944,0.3897058823529412},new double[]{0.09798270893371758,0.05859750240153699,0.027857829010566763},new double[]{-2.340904063229686,-2.2302468420557906,-2.0417006087221674});
		addEdge(citySearch("Kobenhavn"), citySearch("Stockholm"), 3, 0, TrainColor.White,new double[]{0.3550420168067227,0.3744747899159664,0.39653361344537813},new double[]{0.11239193083573487,0.07492795389048991,0.043227665706051875},new double[]{-2.368685412425412,-2.2374930920356877,-2.067026005822105});
		addEdge(citySearch("Stockholm"), citySearch("Petrograd"), 8, 0, TrainColor.Wild, true,new double[]{0.4375,0.45115546218487396,0.47846638655462187,0.5063025210084033,0.5351890756302521,0.5635504201680672,0.5919117647058824,0.6202731092436975},new double[]{0.023054755043227664,0.0393852065321806,0.008645533141210375,0.007684918347742555,0.008645533141210375,0.007684918347742555,0.008645533141210375,0.012487992315081652},new double[]{-0.6657134813885612,-2.1702774277028527,-1.5692036732051036,-1.5930086993901735,-1.593589082377822,-1.5692036732051036,-1.5692036732051036,-1.2261797327844});
		addEdge(citySearch("Petrograd"), citySearch("Rica"), 4, 0, TrainColor.Wild,new double[]{0.5288865546218487,0.5572478991596639,0.5850840336134454,0.6134453781512605},new double[]{0.04899135446685879,0.04707012487992315,0.04707012487992315,0.04610951008645533},new double[]{-1.5896090038916415,-1.5896090038916415,-1.5896090038916415,-1.5896090038916415});
		addEdge(citySearch("Petrograd"), citySearch("Wilno"), 4, 0, TrainColor.Blue,new double[]{0.6444327731092437,0.6276260504201681,0.6118697478991597,0.595063025210084},new double[]{0.05763688760806916,0.09990393852065321,0.14024975984630164,0.18155619596541786},new double[]{-5.693590050042226,-5.651191232116286,-5.64220674790362,-5.629723539284216});
		addEdge(citySearch("Petrograd"), citySearch("Moskova"), 4, 0, TrainColor.White);
		addEdge(citySearch("Moskova"), citySearch("Smolensk"), 2, 0, TrainColor.Orange);
		addEdge(citySearch("Moskova"), citySearch("Kharkov"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Wilno"), citySearch("Kyiv"), 2, 0, TrainColor.Wild);
		addEdge(citySearch("Wilno"), citySearch("Warszawa"), 3, 0, TrainColor.Red);
		addEdge(citySearch("Smolensk"), citySearch("Wilno"), 3, 0, TrainColor.Yellow);
		addEdge(citySearch("Smolensk"), citySearch("Kyiv"), 3, 0, TrainColor.Red);
		addEdge(citySearch("Rica"), citySearch("Wilno"), 4, 0, TrainColor.Green);
		addEdge(citySearch("Kyiv"), citySearch("Warszawa"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Kyiv"), citySearch("Kharkov"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Kyiv"), citySearch("Bucuresti"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Kyiv"), citySearch("Budapest"), 6, 0, TrainColor.Wild, true);
		addEdge(citySearch("Kharkov"), citySearch("Rostov"), 2, 0, TrainColor.Green);
		addEdge(citySearch("Rostov"), citySearch("Sevastopol"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Rostov"), citySearch("Sochi"), 2, 0, TrainColor.Wild);
		addEdge(citySearch("Sevastopol"), citySearch("Bucuresti"), 4, 0, TrainColor.White);
		addEdge(citySearch("Sevastopol"), citySearch("Constantinople"), 4, 2, TrainColor.Wild);
		addEdge(citySearch("Sevastopol"), citySearch("Erzurum"), 4, 2, TrainColor.Wild);
		addEdge(citySearch("Sevastopol"), citySearch("Sochi"), 2, 1, TrainColor.Wild);
		addEdge(citySearch("Sochi"), citySearch("Erzurum"), 3, 0, TrainColor.Red, true);
		addEdge(citySearch("Erzurum"), citySearch("Ancora"), 3, 0, TrainColor.Black, new double[]{0.7226890756302521,0.6980042016806722,0.6701680672268907},new double[]{0.7953890489913544,0.8328530259365994,0.8232468780019212},new double[]{-0.20016969073049395,-1.7140161714440425,-1.0857566716379043});
		addEdge(citySearch("Ancora"), citySearch("Smyrna"), 3, 0, TrainColor.Orange, true, new double[]{0.5793067226890757,0.6102941176470589,0.6559873949579832},new double[]{0.8424591738712777,0.8453410182516811,0.8203650336215178},new double[]{-1.4824653345291183,-1.6967132314203417,-5.105587446494658});
		addEdge(citySearch("Ancora"), citySearch("Constantinople"), 2, 0, TrainColor.Wild, true, 0.6113445378151261,0.6360294117647058},new double[]{0.7560038424591738,0.7829010566762729},new double[]{-1.0206542707545752,-0.9364548382029203});
		addEdge(citySearch("Smyrna"), citySearch("Palermo"), 6, 2, TrainColor.Wild, new double[]{0.5635504201680672,0.5351890756302521,0.5057773109243697,0.47846638655462187,0.4495798319327731,0.4227941176470588},new double[]{0.8414985590778098,0.840537944284342,0.840537944284342,0.8395773294908742,0.8395773294908742,0.840537944284342},new double[]{-4.691190995937692,-4.730401657652101,-4.710796326794897,-4.688577761468178,-4.650868171673689,-4.650868171673689});
		addEdge(citySearch("Smyrna"), citySearch("Athina"), 2, 1, TrainColor.Wild, new double[]{0.5378151260504201,0.5414915966386554},new double[]{0.8021133525456292,0.8184438040345822},new double[]{-4.7316266468311134,-1.161054569450014});
		addEdge(citySearch("Smyrna"), citySearch("Constantinople"), 2, 0, TrainColor.Wild, true, new double[]{0.5955882352941176,0.5814075630252101},new double[]{0.7463976945244957,0.7944284341978867},new double[]{-5.745157195985062,-5.759189221873264});
		addEdge(citySearch("Palermo"), citySearch("Brindisi"), 3, 1, TrainColor.Wild);
		addEdge(citySearch("Palermo"), citySearch("Roma"), 4, 1, TrainColor.Wild);
		addEdge(citySearch("Constantinople"), citySearch("Bucuresti"), 3, 0, TrainColor.Yellow);
		addEdge(citySearch("Constantinople"), citySearch("Sofia"), 3, 0, TrainColor.Blue);
		addEdge(citySearch("Bucuresti"), citySearch("Budapest"), 4, 0, TrainColor.Wild, true);
		addEdge(citySearch("Bucuresti"), citySearch("Sofia"), 2, 0, TrainColor.Wild, true);
		addEdge(citySearch("Sofia"), citySearch("Sarajevo"), 2, 0, TrainColor.Wild, true);
		addEdge(citySearch("Sofia"), citySearch("Athina"), 3, 0, TrainColor.Pink);
		addEdge(citySearch("Athina"), citySearch("Brindisi"), 4, 1, TrainColor.Wild);
		addEdge(citySearch("Athina"), citySearch("Sarajevo"), 4, 0, TrainColor.Green);
		addEdge(citySearch("Brindisi"), citySearch("Roma"), 2, 0, TrainColor.White);
		addEdge(citySearch("Sarajevo"), citySearch("Zacrad"), 3, 0, TrainColor.Red);
		addEdge(citySearch("Sarajevo"), citySearch("Budapest"), 3, 0, TrainColor.Pink);
		addEdge(citySearch("Budapest"), citySearch("Zacrad"), 2, 0, TrainColor.Orange);
		addEdge(citySearch("Budapest"), citySearch("Wien"), 1, 0, TrainColor.White);
		addEdge(citySearch("Budapest"), citySearch("Wien"), 1, 0, TrainColor.Red);
		addEdge(citySearch("Warszawa"), citySearch("Danzic"), 2, 0, TrainColor.Wild);
		addEdge(citySearch("Warszawa"), citySearch("Berlin"), 4, 0, TrainColor.Pink);
		addEdge(citySearch("Warszawa"), citySearch("Berlin"), 4, 0, TrainColor.Yellow);
		addEdge(citySearch("Warszawa"), citySearch("Wien"), 4, 0, TrainColor.Blue);
		addEdge(citySearch("Danzic"), citySearch("Rica"), 3, 0, TrainColor.Black);
		addEdge(citySearch("Danzic"), citySearch("Berlin"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Berlin"), citySearch("Wien"), 3, 0, TrainColor.Green);
		addEdge(citySearch("Zacrad"), citySearch("Wien"), 2, 0, TrainColor.Wild);
		addEdge(citySearch("Zacrad"), citySearch("Venezia"), 2, 0, TrainColor.Wild);
		addEdge(citySearch("Venezia"), citySearch("Roma"), 2, 0, TrainColor.Black);
		addEdge(citySearch("Venezia"), citySearch("Monchen"), 2, 0, TrainColor.Blue, true);
		addEdge(citySearch("Venezia"), citySearch("Zurich"), 2, 0, TrainColor.Green, true);
		addEdge(citySearch("Wien"), citySearch("Monchen"), 3, 0, TrainColor.Orange);
		addEdge(citySearch("Monchen"), citySearch("Zurich"), 2, 0, TrainColor.Yellow, true);
		addEdge(citySearch("Zurich"), citySearch("Marseille"), 2, 0, TrainColor.Pink, true);
		addEdge(citySearch("Zurich"), citySearch("Paris"), 3, 0, TrainColor.Wild, true);
		addEdge(citySearch("Paris"), citySearch("Pamplona"), 4, 0, TrainColor.Green);
		addEdge(citySearch("Paris"), citySearch("Pamplona"), 4, 0, TrainColor.Blue);
		addEdge(citySearch("Paris"), citySearch("Marseille"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Roma"), citySearch("Marseille"), 4, 0, TrainColor.Wild, true);
		addEdge(citySearch("Marseille"), citySearch("Pamplona"), 4, 0, TrainColor.Red);
		addEdge(citySearch("Marseille"), citySearch("Barcelona"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Barcelona"), citySearch("Madrid"), 2, 0, TrainColor.Yellow);
		addEdge(citySearch("Pamplona"), citySearch("Madrid"), 3, 0, TrainColor.Black, true, new double[]{0.12342436974789917,0.09873949579831932,0.07720588235294118},new double[]{0.6311239193083573,0.6570605187319885,0.6954851104707013},new double[]{-5.112666974235354,-5.4273380008913,-5.6183896608837});
		addEdge(citySearch("Pamplona"), citySearch("Madrid"), 3, 0, TrainColor.White, true, new double[]{0.13130252100840337,0.10451680672268908,0.08665966386554622},new double[]{0.6426512968299711,0.6724303554274735,0.7089337175792507},new double[]{-5.211809713598486,-5.529515486070592,-5.560621329617899});
		addEdge(citySearch("Pamplona"), citySearch("Barcelona"), 2, 0, TrainColor.Wild, true, new double[]{0.13760504201680673,0.1402310924369748},new double[]{0.6589817483189241,0.7060518731988472},new double[]{-0.09807599890136887,-0.0714479117133262});
		addEdge(citySearch("Madrid"), citySearch("Lisboa"), 3, 0, TrainColor.Pink, new double[]{0.005777310924369748,0.0063025210084033615,0.03413865546218487},new double[]{0.7223823246878002,0.7166186359269933,0.7185398655139289},new double[]{-6.281592653589794,-1.5692036732051036,-0.9514479476388709});
		addEdge(citySearch("Lisboa"), citySearch("Cadiz"), 2, 0, TrainColor.Blue, new double[]{0.01050420168067227,0.028361344537815126},new double[]{0.7944284341978867,0.8453410182516811},new double[]{-0.4120965596890702,-1.3932640477525755});
		addEdge(citySearch("Cadiz"), citySearch("Madrid"), 3, 0, TrainColor.Orange, new double[]{0.09191176470588236,0.08876050420168068,0.06775210084033613},new double[]{0.8270893371757925,0.7982708933717579,0.7646493756003843},new double[]{-5.059567330378804,-0.312639245494545,-0.8772822909662445});



	}

	public City citySearch(String name) {

		int tracker = 0;


		while (name.compareTo(cities.get(tracker).getName()) != 0) {
			tracker++;
		}
		return cities.get(tracker);
	}

	public ArrayList<Road> roadSearch(City a, City b) {
		ArrayList<Road> result = new ArrayList<>();
		for (Road n: a.getRoads()) {
			if (n.getOtherNode(a).getName().equals(b.getName())) {
				result.add(n);
			}
		}

		return result;
	}



}
