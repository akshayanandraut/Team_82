package io.github.sidrai97.team_82;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {
    private int backPressed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //turn off title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //request fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    /*    GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);*/


        //IGNORE ALL THAT IS AFTER AND BEFORE THIS PATTERN ========================----====================

        //String[] arrayOfDatasetCodes = {"NSE/NV20","NSE/CNX_DIVIDEND_OPPT","NSE/NIFTY_GROWSECT_15","NSE/NI15","NSE/NIFTY100_EQUAL_WEIGHT","NSE/NIFTY50_DIV_POINT","NSE/CNX_ALPHA_INDEX","NSE/CNX_HIGH_BETA","NSE/CNX_100_EQUAL_WEIGHT","NSE/NIFTY_LOW_VOLATILITY_50","NSE/CNX_LOW_VOLATILITY","NSE/NIFTY_DIV_OPPS_50","NSE/CNX_NIFTY_SHARIAH","NSE/NIFTY50_SHARIAH","NSE/CNX_500_SHARIAH","NSE/NIFTY_DIVIDEND","NSE/NIFTY50_VALUE_20","NSE/NIFTY_SERV_SECTOR","NSE/NIFTY_HIGH_BETA_50","NSE/NIFTY_PSE","NSE/NIFTY500_SHARIAH","NSE/NIFTY_ALPHA_50","NSE/CNX_PSE","NSE/CNX_SERVICE","NSE/CNX_SHARIAH25","NSE/CNX_MNC","NSE/NIFTY_SHARIAH_25","NSE/NIFTY_MNC","NSE/NIFTY_INFRA","NSE/CNX_COMMODITIES","NSE/CNX_PHARMA","NSE/CNX_CONSUMPTION","NSE/CNX_IT","NSE/CNX_INFRA","NSE/CPSE_INDEX","NSE/NIFTY_PSU_BANK","NSE/NIFTY_CPSE","NSE/NIFTY_REALTY","NSE/CNX_REALTY","NSE/NIFTY_CONSUMPTION","NSE/CNX_METAL","NSE/NIFTY_COMMODITIES","NSE/NIFTY_METAL","NSE/NIFTY_PHARMA","NSE/CNX_PSU_BANK","NSE/CNX_FINANCE","NSE/NIFTY_MEDIA","NSE/NIFTY_IT","NSE/CNX_MEDIA","NSE/CNX_FMCG","NSE/NIFTY_FMCG","NSE/NIFTY_FIN_SERVICE","NSE/CNX_ENERGY","NSE/NIFTY_AUTO","NSE/NIFTY_BANK","NSE/CNX_AUTO","NSE/NIFTY_ENERGY","NSE/CNX_BANK","NSE/NIFTY_MIDCAP_50","NSE/NIFTY_100","NSE/CNX_500","NSE/CNX_100","NSE/CNX_200","NSE/NIFTY_200","NSE/NIFTY_500","NSE/LIX_15","NSE/NIFTY_50","NSE/NIFTY100_LIQ_15","NSE/CNX_NIFTY","NSE/ZUARIGLOB","NSE/ZODIACLOTH","NSE/ZYDUSWELL","NSE/ZUARI","NSE/XPROINDIA","NSE/ZODJRDMKJ","NSE/ZENTEC","NSE/ZEEMEDIA","NSE/ZICOM","NSE/ZENSARTECH","NSE/WSI","NSE/ZEELEARN","NSE/WHIRLPOOL","NSE/XCHANGING","NSE/WOCKPHARMA","NSE/ZEEL","NSE/ZANDUREALT","NSE/WINSOME","NSE/YESBANK","NSE/WSTCSTPAPR","NSE/WIPRO","NSE/WONDERLA","NSE/WILLAMAGOR","NSE/WABAG","NSE/WELCORP","NSE/WELINV","NSE/WHEELS","NSE/WINDMACHIN","NSE/WEIZMANIND","NSE/WALCHANNAG","NSE/WENDT","NSE/WEBELSOLAR","NSE/WELSPUNIND","NSE/VTL","NSE/WEIZFOREX","NSE/WABCOINDIA","NSE/WELENT","NSE/VSSL","NSE/VSTIND","NSE/VSTTILLERS","NSE/VRLLOG","NSE/VOLTAMP","NSE/VOLTAS","NSE/VMART","NSE/VIVIDHA","NSE/VIVIMEDLAB","NSE/VISAKAIND","NSE/VISHNU","NSE/VLSFINANCE","NSE/VISASTEEL","NSE/VIPULLTD","NSE/VINATIORGA","NSE/VIPIND","NSE/VINYLINDIA","NSE/VINDHYATEL","NSE/VIPCLOTHNG","NSE/VIMALOIL","NSE/VIKASECO","NSE/VIJSHAN","NSE/VIMTALABS","NSE/VESUVIUS","NSE/VHL","NSE/VICEROY","NSE/VIDEOIND","NSE/VIJAYABANK","NSE/VIDHIDYE","NSE/VETO","NSE/VARDHACRLC","NSE/VENKEYS","NSE/VASWANI","NSE/VENUSREM","NSE/VASCONEQ","NSE/VGUARD","NSE/VEDL","NSE/VARDMNPOLY","NSE/VAKRANGEE","NSE/VBL","NSE/VALUEIND","NSE/UTISENSETF","NSE/VAIBHAVGBL","NSE/UTTAMSUGAR","NSE/VADILALIND","NSE/UNITEDTEA","NSE/V2RETAIL","NSE/UPERGANGES","NSE/USHAMART","NSE/UVSL","NSE/UNIVCABLES","NSE/UTTAMSTL","NSE/UTINIFTETF","NSE/UPL","NSE/UNITEDBNK","NSE/USHERAGRO","NSE/UNICHEMLAB","NSE/UNITY","NSE/UNIONBANK","NSE/UJJIVAN","NSE/UNIENTER","NSE/UNIPLY","NSE/UJAAS","NSE/UNITECH","NSE/UMANGDAIRY","NSE/UGARSUGAR","NSE/UFO","NSE/UCOBANK","NSE/ULTRACEMCO","NSE/TI","NSE/TORNTPOWER","NSE/TPLPLASTEH","NSE/TORNTPHARM","NSE/TNPETRO","NSE/TIRUMALCHM","NSE/TIL","NSE/TREEHOUSE","NSE/TNPL","NSE/TIMETECHNO","NSE/TITAN","NSE/TMRVL","NSE/TIIL","NSE/TIMKEN","NSE/TINPLATE","NSE/TIDEWATER","NSE/TIMESGTY","NSE/THOMASCOOK","NSE/TGBHOTELS","NSE/THIRUSUGAR","NSE/THYROCARE","NSE/TEXINFRA","NSE/THERMAX","NSE/TIJARIA","NSE/TFL","NSE/TDPOWERSYS","NSE/TERASOFT","NSE/THEMISMED","NSE/TEXMOPIPES","NSE/THANGAMAYL","NSE/TEXRAIL","NSE/TFCILTD","NSE/TCS","NSE/TECHNO","NSE/TECHM","NSE/TCIFINANCE","NSE/TECHNOFAB","NSE/TCI","NSE/TATAELXSI","NSE/TCIDEVELOP","NSE/TEAMLEASE","NSE/TATAMOTORS","NSE/TBZ","NSE/TATAMETALI","NSE/TATAPOWER","NSE/TATACOMM","NSE/TATAGLOBAL","NSE/TATAMTRDVR","NSE/TATASTEEL","NSE/TCIEXP","NSE/TATASPONGE","NSE/TARAJEWELS","NSE/TATAINVEST","NSE/TATACOFFEE","NSE/TAJGVK","NSE/TARMAT","NSE/TANLA","NSE/TALBROAUTO","NSE/TALWALKARS","NSE/TATACHEM","NSE/TANTIACONS","NSE/SURANASOL","NSE/TAKE","NSE/SYMPHONY","NSE/SYNDIBANK","NSE/SYNGENE","NSE/SYNCOM","NSE/SWELECTES","NSE/SUZLON","NSE/SWARAJENG","NSE/SWANENERGY","NSE/SUTLEJTEX","NSE/SURANATP","NSE/SURYAROSNI","NSE/SUVEN","NSE/SUPERHOUSE","NSE/SURYALAXMI","NSE/SUNILHITEC","NSE/SUPREMEIND","NSE/SURANACORP","NSE/SUPERSPIN","NSE/SUPREMETEX","NSE/SURANAIND","NSE/SUPREMEINF","NSE/SUPPETRO","NSE/SUNTV","NSE/SUPRAJIT","NSE/SUNDARMFIN","NSE/SUNFLAG","NSE/SUNTECK","NSE/SUNDRMFAST","NSE/SUNPHARMA","NSE/SUNDRMBRAK","NSE/SUNDARAM","NSE/SUJANATWR","NSE/SUMMITSEC","NSE/SUJANAUNI","NSE/SUBEX","NSE/SUDARSCHEM","NSE/SUNCLAYLTD","NSE/SUBROS","NSE/STOREONE","NSE/STERLINBIO","NSE/SUMEETINDS","NSE/STRTECH","NSE/STINDIA","NSE/SATIN","NSE/SEQUENT","NSE/SCHNEIDER","NSE/SEINV","NSE/SBIN","NSE/SCI","NSE/SBT","NSE/SASTASUNDR","NSE/SASKEN","NSE/SATHAISPAT","NSE/SANGAMIND","NSE/SAREGAMA","NSE/SANOFI","NSE/SARLAPOLY","NSE/SARDAEN","NSE/SANGHVIFOR","NSE/SANGHIIND","NSE/SANWARIA","NSE/SANDESH","NSE/SALZERELEC","NSE/SAMBHAAV","NSE/SANGHVIMOV","NSE/SANCO","NSE/SAKSOFT","NSE/SAKHTISUG","NSE/SAGCEM","NSE/SALORAINTL","NSE/SALONA","NSE/SAKUMA","NSE/SALSTEEL","NSE/SAIL","NSE/RTNINFRA","NSE/SADBHIN","NSE/SADBHAV","NSE/RUSHIL","NSE/RUPA","NSE/SABTN","NSE/SABEVENTS","NSE/RUCHISOYA","NSE/RUBYMILLS","NSE/RUCHIRA","NSE/RPOWER","NSE/RRSLGETF","NSE/RSWM","NSE/RSSOFTWARE","NSE/RTNPOWER","NSE/RPGLIFE","NSE/ROSSELLIND","NSE/RPPINFRA","NSE/RSYSTEMS","NSE/ROLLT","NSE/ROLTA","NSE/RKFORGE","NSE/ROHLTD","NSE/RJL","NSE/ROHITFERRO","NSE/RMCL","NSE/RKDL","NSE/RML","NSE/RELINFRA","NSE/RIIL","NSE/RICOAUTO","NSE/REPCOHOME","NSE/REPRO","NSE/RESPONIND","NSE/REVATHI","NSE/RELNV20","NSE/RENUKA","NSE/RELDIVOPP","NSE/REMSONSIND","NSE/RELCNX100","NSE/RELIGARE","NSE/RELIANCE","NSE/RELCAPITAL","NSE/REFEX","NSE/RELCONS","NSE/RELAXO","NSE/RDEL","NSE/REDINGTON","NSE/RCOM","NSE/REIAGROLTD","NSE/RCF","NSE/RBL","NSE/RECLTD","NSE/RAYMOND","NSE/RANEHOLDIN","NSE/RASOYPR","NSE/RATNAMANI","NSE/RBLBANK","NSE/RALLIS","NSE/RANASUG","NSE/RAMASTEEL","NSE/RAMCOIND","NSE/RANEENGINE","NSE/RAMCOSYS","NSE/UFLEX","NSE/TVSSRICHAK","NSE/TVTODAY","NSE/UBHOLDINGS","NSE/TVVISION","NSE/UCALFUEL","NSE/TWL","NSE/TV18BRDCST","NSE/UBL","NSE/TVSMOTOR","NSE/TTKPRESTIG","NSE/TUBEINVEST","NSE/TULSI","NSE/TRIVENI","NSE/TVSELECT","NSE/TTML","NSE/TTL","NSE/TTKHLTCARE","NSE/TRIDENT","NSE/TRIL","NSE/TRITURBINE","NSE/TRICOM","NSE/TRF","NSE/TRENT","NSE/TOKYOPLAST","NSE/RAMKY","NSE/RAJTV","NSE/RAMCOCEM","NSE/RAJRAYON","NSE/QUICKHEAL","NSE/RAJSREESUG","NSE/RAMANEWS","NSE/RAJVIR","NSE/RAINBOWPAP","NSE/RAJOIL","NSE/RAJESHEXPO","NSE/QUESS","NSE/RAIREKMOH","NSE/RADICO","NSE/PRISMCEM","NSE/PRATIBHA","NSE/PRESTIGE","NSE/PRECOT","NSE/PRECWIRE","NSE/PREMEXPLN","NSE/PRAKASHSTL","NSE/PRECAM","NSE/PRAKASH","NSE/PRAKASHCON","NSE/PRAENG","NSE/PRAJIND","NSE/PPAP","NSE/POWERGRID","NSE/POWERMECH","NSE/POLYPLEX","NSE/PRABHAT","NSE/POKARNA","NSE/PONNIERODE","NSE/PODDARMENT","NSE/POLYMED","NSE/PNBGILTS","NSE/PNCINFRA","NSE/PNC","NSE/PNB","NSE/PNEUMATIC","NSE/POLARIS","NSE/PIONEEREMB","NSE/PNBHOUSING","NSE/POCHIRAJU","NSE/PLASTIBLEN","NSE/PIRPHYTO","NSE/PITTILAM","NSE/PKTEA","NSE/PIDILITIND","NSE/PINCON","NSE/PIONDIST","NSE/PHOENIXLL","NSE/PIIND","NSE/PETRONET","NSE/PHOENIXLTD","NSE/PHILIPCARB","NSE/PILITA","NSE/PGEL","NSE/PGIL","NSE/PEL","NSE/PFIZER","NSE/PFC","NSE/PFS","NSE/PGHH","NSE/PFOCUS","NSE/PENINLAND","NSE/PDPL","NSE/PENIND","NSE/PEARLPOLY","NSE/PETRONENGG","NSE/PERSISTENT","NSE/PENPEBS","NSE/PDMJEPAPER","NSE/PDUMJEIND","NSE/PATINTLOG","NSE/PDSMFL","NSE/PATSPINLTD","NSE/PDUMJEPULP","NSE/PATELENG","NSE/PARABDRUGS","NSE/PCJEWELLER","NSE/PARAGMILK","NSE/PARRYSUGAR","NSE/PARSVNATH","NSE/PBAINFRA","NSE/PARACABLES","NSE/PAPERPROD","NSE/PALREDTEC","NSE/PANAMAPET","NSE/PAEL","NSE/PANACEABIO","NSE/ORISSAMINE","NSE/ORIENTCEM","NSE/PANORAMUNI","NSE/ORTINLABSS","NSE/OUDHSUG","NSE/ORIENTREF","NSE/PAGEIND","NSE/ORTEL","NSE/ORIENTPPR","NSE/ORIENTLTD","NSE/ORIENTHOT","NSE/ORBTEXP","NSE/ORIENTBELL","NSE/ORIENTALTL","NSE/ORIENTABRA","NSE/OPTOCIRCUI","NSE/ORIENTBANK","NSE/ORCHIDPHAR","NSE/ORICONENT","NSE/STEL","NSE/SSWL","NSE/SRIPIPES","NSE/STAMPEDE","NSE/STARPAPER","NSE/STCINDIA","NSE/STAR","NSE/STERTOOLS","NSE/SRTRANSFIN","NSE/SRF","NSE/SRSLTD","NSE/SRHHYPOLTD","NSE/SQSBFSI","NSE/SPYL","NSE/SREINFRA","NSE/SPMLINFRA","NSE/SREEL","NSE/SPARC","NSE/SPLIL","NSE/SPHEREGSL","NSE/SPIC","NSE/SPECIALITY","NSE/SPICEMOBI","NSE/SONATSOFTW","NSE/SOTL","NSE/SONASTEER","NSE/SPAL","NSE/SOUTHBANK","NSE/SOMANYCERA","NSE/SOLARINDS","NSE/SOMICONVEY","NSE/SOBHA","NSE/SMPL","NSE/SNOWMAN","NSE/SMLISUZU","NSE/SITINET","NSE/SMSPHARMA","NSE/SIYSIL","NSE/SKFINDIA","NSE/SOMATEX","NSE/SKIPPER","NSE/SKMEGGPROD","NSE/SKIL","NSE/SMARTLINK","NSE/SINTEX","NSE/SIMPLEX","NSE/SIGNET","NSE/SJVN","NSE/SIMBHALS","NSE/SITASHREE","NSE/SICAL","NSE/SIEMENS","NSE/SHYAMCENT","NSE/SICAGEN","NSE/SIMPLEXINF","NSE/SHYAMTEL","NSE/SILINV","NSE/SHREERAMA","NSE/SHREYAS","NSE/SHRIRAMCIT","NSE/SHK","NSE/SHRIRAMEPC","NSE/SHREECEM","NSE/SHREYANIND","NSE/SHEMAROO","NSE/SHREEPUSHK","NSE/SHRENUJ","NSE/SHOPERSTOP","NSE/SHIVTEX","NSE/SHILPAMED","NSE/SHILPI","NSE/SHIRPUR_G","NSE/SHARDAMOTR","NSE/SHARDACROP","NSE/SHARONBIO","NSE/SHIVAMAUTO","NSE/SFCL","NSE/SHANTIGEAR","NSE/SHAKTIPUMP","NSE/SHALPAINTS","NSE/SHARIABEES","NSE/SFL","NSE/SESHAPAPER","NSE/SGL","NSE/SERVALL","NSE/SETFGOLD","NSE/SETFNN50","NSE/SETF10GILT","NSE/SELMCL","NSE/SETFNIFBK","NSE/SEAMECLTD","NSE/SELAN","NSE/SENSEXIWIN","NSE/SDBL","NSE/SETFNIF50","NSE/SETCO","NSE/SBBJ","NSE/ONMOBILE","NSE/ORBITCORP","NSE/ONWARDTEC","NSE/OMAXE","NSE/ONELIFECAP","NSE/OMKARCHEM","NSE/ONGC","NSE/OMMETALS","NSE/OMAXAUTO","NSE/OIL","NSE/OISL","NSE/OCCL","NSE/NFL","NSE/NIITLTD","NSE/NIF100IWIN","NSE/NH","NSE/NIFTYEES","NSE/NETWORK18","NSE/NHPC","NSE/NEULANDLAB","NSE/NECCLTD","NSE/NESTLEIND","NSE/NESCO","NSE/NEXTMEDIA","NSE/NELCAST","NSE/NDTV","NSE/NECLIFE","NSE/NDL","NSE/NDGL","NSE/NELCO","NSE/NCC","NSE/NAVNETEDUL","NSE/NAUKRI","NSE/NBCC","NSE/NAVKARCORP","NSE/NAVINFLUOR","NSE/NCLIND","NSE/NBVENTURES","NSE/NATIONALUM","NSE/NAKODA","NSE/NATHBIOGEN","NSE/NATCOPHARM","NSE/NAGREEKEXP","NSE/NAGAROIL","NSE/NAHARSPING","NSE/NAHARINDUS","NSE/N100","NSE/MVL","NSE/MUTHOOTCAP","NSE/NAGREEKCAP","NSE/MUNJALSHOW","NSE/NAHARPOLY","NSE/NAHARCAP","NSE/MYSOREBANK","NSE/MUKANDENGG","NSE/MUTHOOTFIN","NSE/MURUDCERA","NSE/MUKTAARTS","NSE/MUKANDLTD","NSE/MTEDUCARE","NSE/MRPL","NSE/MUNJALAU","NSE/MTNL","NSE/MPSLTD","NSE/MOREPENLAB","NSE/MRF","NSE/MSPL","NSE/MOTILALOFS","NSE/MPHASIS","NSE/MRO_TEK","NSE/MOTHERSUMI","NSE/MOSERBAER","NSE/MOLDTKPAC","NSE/MOLDTECH","NSE/MONTECARLO","NSE/MOIL","NSE/MONSANTO","NSE/MORARJEE","NSE/MONNETISPA","NSE/MMFIN","NSE/MMTC","NSE/MOHITIND","NSE/MMFL","NSE/MM","NSE/MINDTREE","NSE/MIRZAINT","NSE/MIC","NSE/MIRCELECTR","NSE/MHRIL","NSE/MEP","NSE/MINDAIND","NSE/MGL","NSE/MINDTECK","NSE/MFSL","NSE/MINDACORP","NSE/MIDCAPIWIN","NSE/MERCK","NSE/METALFORGE","NSE/METKORE","NSE/MEGH","NSE/MENONBE","NSE/MERCATOR","NSE/MEGASOFT","NSE/MBECL","NSE/MCX","NSE/MCLEODRUSS","NSE/MAXVIL","NSE/QGOLDHALF","NSE/RAIN","NSE/PVR","NSE/PUNJLLOYD","NSE/QNIFTY","NSE/PUNJABCHEM","NSE/PROZONINTU","NSE/PSL","NSE/PTL","NSE/PVP","NSE/PSUBNKBEES","NSE/PTC","NSE/PSB","NSE/PURVA","NSE/PROVOGE","NSE/PREMIER","NSE/PRESSMN","NSE/PRIMESECU","NSE/MBLINFRA","NSE/MCDOWELL_N","NSE/MCDHOLDING","NSE/MARUTI","NSE/MAXINDIA","NSE/MAZDA","NSE/MAYURUNIQ","NSE/MANINDS","NSE/MANPASAND","NSE/MAWANASUG","NSE/MANUGRAPH","NSE/MASTEK","NSE/MARKSANS","NSE/KINGFA","NSE/KHANDSE","NSE/KIRLOSENG","NSE/KICL","NSE/KGL","NSE/KIRIINDUS","NSE/KIRLOSIND","NSE/KHAITANELE","NSE/KEI","NSE/KESORAMIND","NSE/KESARENT","NSE/KECL","NSE/KELLTONTEC","NSE/KCP","NSE/KDDL","NSE/KEC","NSE/KARURVYSYA","NSE/KANSAINER","NSE/KAVVERITEL","NSE/KCPSUGIND","NSE/KAYA","NSE/KANORICHEM","NSE/KAUSHALYA","NSE/KAKATCEM","NSE/KANANIIND","NSE/KARMAENG","NSE/KAMDHENU","NSE/KAMATHOTEL","NSE/KALINDEE","NSE/JYOTHYLAB","NSE/JYOTISTRUC","NSE/JUSTDIAL","NSE/JUNIORBEES","NSE/KALPATPOWR","NSE/KAJARIACER","NSE/JUBLINDS","NSE/KABRAEXTRU","NSE/JVLAGRO","NSE/JPPOWER","NSE/JSWHL","NSE/JUBILANT","NSE/JSWSTEEL","NSE/JUBLFOOD","NSE/JSWENERGY","NSE/JKLAKSHMI","NSE/JMA","NSE/JSLHISAR","NSE/JSL","NSE/JPOLYINVST","NSE/JOCIL","NSE/JPINFRATEC","NSE/JPASSOCIAT","NSE/JKPAPER","NSE/JMCPROJECT","NSE/JMTAUTOLTD","NSE/JMFINANCIL","NSE/JENSONICOL","NSE/JINDALPOLY","NSE/JKIL","NSE/JKBANK","NSE/JKTYRE","NSE/JINDALSAW","NSE/JISLDVREQS","NSE/JKCEMENT","NSE/JINDCOT","NSE/JINDALPHOT","NSE/JINDWORLD","NSE/JINDRILL","NSE/JISLJALEQS","NSE/JBMA","NSE/JHS","NSE/JINDALSTEL","NSE/JCHAC","NSE/JAYSREETEA","NSE/JAMNAAUTO","NSE/JBFIND","NSE/JETAIRWAYS","NSE/JAYNECOIND","NSE/JAYBARMARU","NSE/JBCHEPHARM","NSE/IZMO","NSE/JAICORPLTD","NSE/IVP","NSE/JAGRAN","NSE/JAYAGROGN","NSE/IVZINGOLD","NSE/JAIBALAJI","NSE/IVRCLINFRA","NSE/JAGSNPHARM","NSE/IVZINNIFTY","NSE/ITDCEM","NSE/IVC","NSE/ITI","NSE/ISFT","NSE/ITDC","NSE/OILCOUNTUB","NSE/OFSS","NSE/NRBBEARING","NSE/NLCINDIA","NSE/OCL","NSE/NUCLEUS","NSE/NV20IWIN","NSE/NUTEK","NSE/NTPC","NSE/NOIDATOLL","NSE/NITINSPIN","NSE/OBEROIRLTY","NSE/NOCIL","NSE/NSIL","NSE/NMDC","NSE/NKIND","NSE/NITINFIRE","NSE/NITCO","NSE/NILAINFRA","NSE/NIPPOBATRY","NSE/NILKAMAL","NSE/NITESHEST","NSE/NIBL","NSE/NIFTYBEES","NSE/NIITTECH","NSE/NIFTYIWIN","NSE/IPCALAB","NSE/IPAPPM","NSE/IRB","NSE/INTELLECT","NSE/ITC","NSE/IOC","NSE/ISMTLTD","NSE/IOB","NSE/INOXLEISUR","NSE/INVENTURE","NSE/INTEGRA","NSE/INSECTICID","NSE/INOXWIND","NSE/IOLCP","NSE/IGL","NSE/IFCI","NSE/IDBI","NSE/HPL","NSE/IDFNIFTYET","NSE/ICRA","NSE/ICICIPRULI","NSE/ICSA","NSE/IDEA","NSE/IDFC","NSE/IBULHSGFIN","NSE/ICICIBANK","NSE/ICIL","NSE/IBWSL","NSE/IBVENTURES","NSE/HUBTOWN","NSE/HMVL","NSE/IBREALEST","NSE/HONDAPOWER","NSE/HSCL","NSE/HNGSNGBEES","NSE/HTMEDIA","NSE/HONAUT","NSE/HSIL","NSE/HOTELEELA","NSE/HOTELRUGBY","NSE/HOVS","NSE/HINDUNILVR","NSE/HOCL","NSE/HITECHGEAR","NSE/HITECHPLAS","NSE/HINDCOPPER","NSE/HINDUJAFO","NSE/HINDZINC","NSE/HINDNATGLS","NSE/HIRECT","NSE/HINDUJAVEN","NSE/HINDSYNTEX","NSE/HISARMETAL","NSE/HINDPETRO","NSE/HINDCOMPOS","NSE/HINDOILEXP","NSE/HINDMOTORS","NSE/HINDDORROL","NSE/HINDALCO","NSE/HIMATSEIDE","NSE/HILTON","NSE/HIGHGROUND","NSE/HIL","NSE/HFCL","NSE/HIKAL","NSE/HERITGFOOD","NSE/HEXAWARE","NSE/HESTERBIO","NSE/HEG","NSE/HEROMOTOCO","NSE/HGS","NSE/HEXATRADEX","NSE/HDFC","NSE/HDFCSENETF","NSE/HERCULES","NSE/HDIL","NSE/HEIDELBERG","NSE/HDFCMFGETF","NSE/HCL_INSYS","NSE/HDFCBANK","NSE/HCG","NSE/HCLTECH","NSE/HBSTOCK","NSE/HBLPOWER","NSE/HDFCNIFETF","NSE/HCC","NSE/HATSUN","NSE/HAVELLS","NSE/HARRMALAYA","NSE/HATHWAY","NSE/HARITASEAT","NSE/GUJNREDVR","NSE/GULFOILLUB","NSE/GULPOLY","NSE/HANUNG","NSE/GUJNRECOKE","NSE/GVKPIL","NSE/GUJAPOLLO","NSE/GULFPETRO","NSE/GUJGASLTD","NSE/GUJALKALI","NSE/GUJFLUORO","NSE/GTNTEX","NSE/GTNIND","NSE/GRUH","NSE/GTOFFSHORE","NSE/GSCLCEMENT","NSE/MANGCHEFER","NSE/MANAKINDST","NSE/MANAKSIA","NSE/MANGALAM","NSE/MANGTIMBER","NSE/MANALIPETC","NSE/MAITHANALL","NSE/MANAKALUCO","NSE/MANAKCOAT","NSE/MAJESCO","NSE/MAGMA","NSE/MANDHANA","NSE/MALUPAPER","NSE/MAHSEAMLES","NSE/MAHLIFE","NSE/MAHINDCIE","NSE/MADRASFERT","NSE/MAHSCOOTER","NSE/MAHASTEEL","NSE/MAHABANK","NSE/MADHAV","NSE/MAGNUM","NSE/LYCOS","NSE/LYPSAGEMS","NSE/MADHUCON","NSE/M50","NSE/M100","NSE/MAANALU","NSE/LUXIND","NSE/LYKALABS","NSE/LT","NSE/LUMAXTECH","NSE/LTI","NSE/LUPIN","NSE/LUMAXIND","NSE/LTTS","NSE/LTFH","NSE/LOVABLE","NSE/LSIL","NSE/LPDC","NSE/LOTUSEYE","NSE/LINDEINDIA","NSE/LOKESHMACH","NSE/LLOYDELENG","NSE/LINCPEN","NSE/LIQUIDBEES","NSE/LML","NSE/LITL","NSE/LGBFORGE","NSE/LICNETFN50","NSE/LICNFNHGP","NSE/LGBBROSLTD","NSE/LINCOLN","NSE/LICNETFGSC","NSE/LAMBODHARA","NSE/LAURUSLABS","NSE/LICHSGFIN","NSE/LAOPALA","NSE/LALPATHLAB","NSE/LAXMIMACH","NSE/LIBERTSHOE","NSE/LAKSHMIEFL","NSE/LAKSHVILAS","NSE/LAKPRE","NSE/KWALITY","NSE/KTKBANK","NSE/KSCL","NSE/KSL","NSE/KPIT","NSE/KSK","NSE/KOTARISUG","NSE/KTIL","NSE/KRIDHANINF","NSE/KPRMILL","NSE/KRBL","NSE/KSBPUMPS","NSE/KSERASERA","NSE/KOTHARIPRO","NSE/KOTHARIPET","NSE/KOTAKBANK","NSE/KOTAKPSUBK","NSE/KOKUYOCMLN","NSE/KITEX","NSE/KOLTEPATIL","NSE/KOTAKBKETF","NSE/KOTAKGOLD","NSE/KOTAKNIFTY","NSE/KOPRAN","NSE/KOTAKNV20","NSE/KOHINOOR","NSE/KNRCON","NSE/KKCL","NSE/KMSUGAR","NSE/KIRLOSBROS","NSE/KILITCH","NSE/GSFC","NSE/GUFICBIO","NSE/GSKCONS","NSE/GSS","NSE/GTL","NSE/GROBTEA","NSE/GRPLTD","NSE/GTLINFRA","NSE/GSPL","NSE/GREENPOWER","NSE/GREENFIRE","NSE/GREENPLY","NSE/GRINDWELL","NSE/GOODLUCK","NSE/GRASIM","NSE/GPPL","NSE/GRAPHITE","NSE/GPTINFRA","NSE/GOLDTECH","NSE/GPIL","NSE/GOLDSHARE","NSE/GRANULES","NSE/GOLDIAM","NSE/GOLDIWIN","NSE/GOLDBEES","NSE/GOKULAGRO","NSE/GOLDENTOBC","NSE/GOKEX","NSE/GODFRYPHLP","NSE/GODREJCP","NSE/GMRINFRA","NSE/GNA","NSE/GODREJIND","NSE/GOCLCORP","NSE/GMDCLTD","NSE/GOACARBON","NSE/GNFC","NSE/GLOBUSSPR","NSE/GODREJPROP","NSE/GLOBALVECT","NSE/GMBREW","NSE/GITANJALI","NSE/GLOBOFFS","NSE/GKWLIMITED","NSE/GLENMARK","NSE/GILLETTE","NSE/GHCL","NSE/GLAXO","NSE/GILLANDERS","NSE/GICHSGFIN","NSE/GENUSPOWER","NSE/GINNIFILA","NSE/GIPCL","NSE/GEOMETRIC","NSE/GENUSPAPER","NSE/GEPIL","NSE/GESHIP","NSE/GAL","NSE/GEOJITBNPP","NSE/GATI","NSE/GETD","NSE/GARWALLROP","NSE/GEECEE","NSE/GENESYS","NSE/GEMINI","NSE/GDL","NSE/GANESHHOUC","NSE/GALLANTT","NSE/GAYAPROJ","NSE/GARDENSILK","NSE/GAIL","NSE/GAMMONIND","NSE/GANDHITUBE","NSE/FOSECOIND","NSE/GANECOS","NSE/FRETAIL","NSE/GAEL","NSE/GALLISPAT","NSE/FSL","NSE/GABRIEL","NSE/FORTIS","NSE/GAMMNINFRA","NSE/FMGOETZE","NSE/FLFL","NSE/FMNL","NSE/FINPIPE","NSE/FIRSTWIN","NSE/FIEMIND","NSE/FCONSUMER","NSE/FILATEX","NSE/FEL","NSE/FLEXITUFF","NSE/FINANTECH","NSE/FINCABLES","NSE/FCL","NSE/FEDDERLOYD","NSE/FELDVR","NSE/FACT","NSE/EXCEL","NSE/FDC","NSE/FEDERALBNK","NSE/FAGBEARING","NSE/EXCELINDUS","NSE/FCSSOFT","NSE/EXCELCROP","NSE/EVERESTIND","NSE/EXIDEIND","NSE/MARICO","NSE/MANINFRA","NSE/MANAPPURAM","NSE/MANAKSTEEL","NSE/MANGLMCEM","NSE/MARALOVER","NSE/MARATHON","NSE/INGERRAND","NSE/INFOMEDIA","NSE/INFRABEES","NSE/INFRATEL","NSE/INDUSINDBK","NSE/INEOSSTYRO","NSE/INFY","NSE/INFIBEAM","NSE/INDSWFTLTD","NSE/INDSWFTLAB","NSE/INFINITE","NSE/INDTERRAIN","NSE/INDOTECH","NSE/INDOTHAI","NSE/INDRAMEDCO","NSE/INDIANCARD","NSE/INDLMETER","NSE/INDORAMA","NSE/INDOSOLAR","NSE/INDOCO","NSE/INDNIPPON","NSE/INDIAGLYCO","NSE/INDIACEM","NSE/INDIANB","NSE/IMPEXFERRO","NSE/INDBANK","NSE/INDIANHUME","NSE/INDIGO","NSE/IGPL","NSE/INDHOTEL","NSE/IIFL","NSE/ILFSENGG","NSE/IFBAGRO","NSE/IMPAL","NSE/IITL","NSE/IMFA","NSE/ILFSTRANS","NSE/IFBIND","NSE/IGARASHI","NSE/IFGLREFRAC","NSE/IDBIGOLD","NSE/IDFCBANK","NSE/ESSARSHPNG","NSE/EVEREADY","NSE/EUROTEXIND","NSE/ESTER","NSE/EUROCERA","NSE/ESCORTS","NSE/ESSELPACK","NSE/ESABINDIA","NSE/EON","NSE/ESL","NSE/EQ30","NSE/EROSMEDIA","NSE/ENIL","NSE/ECEIND","NSE/EDL","NSE/DSKULKARNI","NSE/EASTSILK","NSE/ECLERX","NSE/DTIL","NSE/DUCON","NSE/DRREDDY","NSE/DREDGECORP","NSE/DYNAMATECH","NSE/DQE","NSE/DIVISLAB","NSE/DLINKINDIA","NSE/DPL","NSE/DOLPHINOFF","NSE/DONEAR","NSE/DLF","NSE/DISHTV","NSE/DICIND","NSE/DISHMAN","NSE/DHAMPURSUG","NSE/DHANBANK","NSE/DHUNINV","NSE/DIAPOWER","NSE/DIGJAMLTD","NSE/DHFL","NSE/DHARSUGAR","NSE/DHANUKA","NSE/DEEPAKNTR","NSE/DEEPIND","NSE/DFMFOODS","NSE/DELTAMAGNT","NSE/DENORA","NSE/DBCORP","NSE/DBREALTY","NSE/DBL","NSE/DEN","NSE/DENABANK","NSE/DEEPAKFERT","NSE/DELTACORP","NSE/DECCANCE","NSE/DCW","NSE/DCBBANK","NSE/DCMSHRIRAM","NSE/DCM","NSE/DBSTOCKBRO","NSE/DATAMATICS","NSE/DALMIASUG","NSE/DALMIABHA","NSE/DAMODARIND","NSE/CYBERMEDIA","NSE/CYBERTECH","NSE/DAAWAT","NSE/DABUR","NSE/CRISIL","NSE/CYIENT","NSE/CTE","NSE/CREST","NSE/CUPID","NSE/CROMPTON","NSE/CUMMINSIND","NSE/CRMFGETF","NSE/CROMPGREAV","NSE/CUB","NSE/COXKINGS","NSE/CPSEETF","NSE/COUNCODOS","NSE/COMPUSOFT","NSE/CORDSCABLE","NSE/COROMANDEL","NSE/CORPBANK","NSE/CONSOFINVT","NSE/COSMOFILMS","NSE/COLPAL","NSE/CONCOR","NSE/COMPINFO","NSE/CONTROLPR","NSE/CLNINDIA","NSE/CNOVAPETRO","NSE/COFFEEDAY","NSE/CINELINE","NSE/CMICABLES","NSE/COALINDIA","NSE/CINEVISTA","NSE/CIGNITITEC","NSE/CIPLA","NSE/CHROMATIC","NSE/CIMMCO","NSE/CHAMBLFERT","NSE/CHENNPETRO","NSE/CHOLAFIN","NSE/CHEMFALKAL","NSE/CGCL","NSE/CEREBRAINT","NSE/CENTURYPLY","NSE/GREAVESCOT","NSE/GREENLAM","NSE/GOLDINFRA","NSE/GRAVITA","NSE/CESC","NSE/CENTUM","NSE/CENTURYTEX","NSE/CENTEXT","NSE/CELESTIAL","NSE/CENTRALBK","NSE/CERA","NSE/CELEBRITY","NSE/CCCL","NSE/CEBBCO","NSE/CCL","NSE/CEATLTD","NSE/CCHHL","NSE/CAPF","NSE/BANARISUG","NSE/BALPHARMA","NSE/BAJFINANCE","NSE/BAJAJFINSV","NSE/BALKRISHNA","NSE/BAJAJHLDNG","NSE/BALAMINES","NSE/BALAJITELE","NSE/BALKRISIND","NSE/BAJAJ_AUTO","NSE/AXISCADES","NSE/BAFNAPHARM","NSE/BAJAJHIND","NSE/AYMSYNTEX","NSE/BAGFILMS","NSE/AXISGOLD","NSE/BAJAJELEC","NSE/BAJAJCORP","NSE/AXISBANK","NSE/AVANTIFEED","NSE/AVTNPL","NSE/AUTOIND","NSE/AUSTRAL","NSE/AUTOAXLES","NSE/AUTOLITIND","NSE/AUSOMENT","NSE/ATULAUTO","NSE/ATUL","NSE/AURIONPRO","NSE/ATLANTA","NSE/AUROPHARMA","NSE/ATLASCYCLE","NSE/ATNINTER","NSE/ATFL","NSE/ASTRAMICRO","NSE/ASTRAZEN","NSE/ASHIMASYN","NSE/ASSAMCO","NSE/ASTRAL","NSE/ASHOKLEY","NSE/ASIANTILES","NSE/ARROWGREEN","NSE/ASHIANA","NSE/ASTEC","NSE/ASIANHOTNR","NSE/ARVSMART","NSE/ASIANPAINT","NSE/ARIES","NSE/ASAHIINDIA","NSE/ARCOTECH","NSE/ASAHISONG","NSE/ASAL","NSE/ARSSINFRA","NSE/ASHAPURMIN","NSE/ASHOKA","NSE/ARVIND","NSE/AROGRANITE","NSE/ARMANFIN","NSE/ARCHIES","NSE/ARROWTEX","NSE/ARSHIYA","NSE/ARCHIDPLY","NSE/APTECHT","NSE/APOLLOHOSP","NSE/APLLTD","NSE/APOLLOTYRE","NSE/APLAPOLLO","NSE/APARINDS","NSE/APCOTEXIND","NSE/ANSALHSG","NSE/ANSALAPI","NSE/ANGIND","NSE/ANKITMETAL","NSE/ANDHRSUGAR","NSE/ANANTRAJ","NSE/ANDHRABANK","NSE/ANDHRACEMT","NSE/AMTL","NSE/AMRUTANJAN","NSE/ALPHAGEO","NSE/AMTEKAUTO","NSE/AMDIND","NSE/AMARAJABAT","NSE/AMBUJACEM","NSE/AMBIKCO","NSE/ALPSINDUS","NSE/ALKEM","NSE/ALANKIT","NSE/ALCHEM","NSE/ALOKTEXT","NSE/ALMONDZ","NSE/ALLCARGO","NSE/ALKALI","NSE/ALKYLAMINE","NSE/ALLSEC","NSE/ALEMBICLTD","NSE/EQUITAS","NSE/ENGINERSIN","NSE/EMMBI","NSE/ENERGYDEV","NSE/EMAMILTD","NSE/EMCO","NSE/EMAMIINFRA","NSE/EMKAY","NSE/ENDURANCE","NSE/ELGIRUBCO","NSE/ELGIEQUIP","NSE/ELAND","NSE/ELECTCAST","NSE/ELECON","NSE/EIHOTEL","NSE/EKC","NSE/ELECTHERM","NSE/EIDPARRY","NSE/EIHAHOTELS","NSE/EDELWEISS","NSE/DWARKESH","NSE/EDUCOMP","NSE/DPSCLTD","NSE/EICHERMOT","NSE/EASUNREYRL","NSE/ALICON","NSE/ALBK","NSE/AKSHOPTFBR","NSE/ALBERTDAVD","NSE/AKZOINDIA","NSE/AJANTPHARM","NSE/AJMERA","NSE/AIFL","NSE/AIAENG","NSE/AHLEAST","NSE/AGCNET","NSE/AHLUCONT","NSE/AHLWEST","NSE/AGRITECH","NSE/ADI","NSE/AGARIND","NSE/AEGISCHEM","NSE/ADORWELD","NSE/AFL","NSE/ADVANIHOTR","NSE/ADVENZYMES","NSE/ADLABS","NSE/ADFFOODS","NSE/ADHUNIKIND","NSE/ADHUNIK","NSE/ADANIPOWER","NSE/ADANITRANS","NSE/ADANIPORTS","NSE/ADANIENT","NSE/ACE","NSE/ACC","NSE/ABIRLANUVO","NSE/3IINFOTECH","NSE/A2ZINFRA","NSE/ABBOTINDIA","NSE/AARTIDRUGS","NSE/3MINDIA","NSE/ACCELYA","NSE/ABGSHIP","NSE/ABFRL","NSE/20MICRONS","NSE/ABAN","NSE/8KMILES","NSE/ABB","NSE/AARVEEDEN","NSE/AARTIIND","NSE/CENTENKA","NSE/CARBORUNIV","NSE/CASTROLIND","NSE/CASTEXTECH","NSE/CARERATING","NSE/CAREERP","NSE/CAMLINFINE","NSE/CANBK","NSE/CANTABIL","NSE/CAPLIPOINT","NSE/CAIRN","NSE/CANFINHOME","NSE/CANDC","NSE/BYKE","NSE/BSLIMITED","NSE/CADILAHC","NSE/BVCL","NSE/BSLNIFTY","NSE/BUTTERFLY","NSE/BRIGADE","NSE/BSELINFRA","NSE/BSL","NSE/BROOKS","NSE/BURNPUR","NSE/BSLGOLDETF","NSE/BPCL","NSE/BOSCHLTD","NSE/BRFL","NSE/BPL","NSE/BOMDYEING","NSE/BRITANNIA","NSE/BODALCHEM","NSE/BLUEDART","NSE/BLISSGVS","NSE/BLUESTARCO","NSE/BIOCON","NSE/BLKASHYAP","NSE/BLUEBLENDS","NSE/BLS","NSE/BIRLAMONEY","NSE/BIRLACORPN","NSE/BIRLACABLE","NSE/BLBLIMITED","NSE/BINANIIND","NSE/BIL","NSE/BHARATWIRE","NSE/BINDALAGRO","NSE/BIGBLOC","NSE/BHARATRAS","NSE/BHUSANSTL","NSE/BHEL","NSE/BHARATGEAR","NSE/BHAGYNAGAR","NSE/BHARATFIN","NSE/BERGEPAINT","NSE/BHAGERIA","NSE/BHARTIARTL","NSE/BHARATFORG","NSE/BFUTILITIE","NSE/BGRENERGY","NSE/BFINVEST","NSE/BEPL","NSE/BEML","NSE/BEDMUTHA","NSE/BEARDSELL","NSE/BEL","NSE/BANSWRAS","NSE/BAYERCROP","NSE/BBL","NSE/BASF","NSE/BBTC","NSE/BANKINDIA","NSE/BANKBEES","NSE/BATAINDIA","NSE/BASML","NSE/BANCOINDIA","NSE/BANG","NSE/BALLARPUR","NSE/BANKBARODA","NSE/BANARBEADS","NSE/BALRAMCHIN","NSE/BALMLAWRIE","NSE/PREMIERPOL","NSE/BLUECOAST","NSE/KEYCORPSER","NSE/EBANK","NSE/ZYLOG","NSE/VIJIFIN","NSE/TRIGYN","NSE/TIPSINDLTD","NSE/TAINWALCHM","NSE/SPENTEX","NSE/SHAHALLOYS","NSE/SEPOWER","NSE/GOKUL","NSE/BARTRONICS","NSE/ARIHANT","NSE/ADSL","NSE/CNX_SMALLCAP","NSE/NIFTY_SMALL_100","NSE/CNX_MIDCAP","NSE/NIFTY_MIDCAP_100","NSE/MAXWELL","NSE/BIRLACOT","NSE/APOLSINHOT","NSE/PRICOL","NSE/ARVINFRA","NSE/SGJHL","NSE/SEZAL","NSE/LICNETFSEN","NSE/BHARATIDIL","NSE/MICROSEC","NSE/ZENITHEXPO","NSE/RELNIFTY","NSE/RELGOLD","NSE/RELBANK","NSE/EVERONN","NSE/FCEL","NSE/VISESHINFO","NSE/VKSPL","NSE/TARAPUR","NSE/MELSTAR","NSE/LCCINFOTEC","NSE/BILENERGY","NSE/ANANDAMRUB","NSE/VALECHAENG","NSE/SVOGL","NSE/AGRODUTCH","NSE/ALSTOMTD","NSE/AIL","NSE/HITACHIHOM","NSE/NIRVIKARA","NSE/SUDAR","NSE/ESSDEE","NSE/NGCT","NSE/SITICABLE","NSE/HCIL","NSE/NEYVELILIG","NSE/ADVANTA","NSE/ISENSEX","NSE/INIFTY","NSE/IMIDCAP","NSE/IGOLD","NSE/ICNX100","NSE/INV20","NSE/SAMTEL","NSE/OMNITECH","NSE/FARMAXIND","NSE/CREATIVEYE","NSE/CALSOFT","NSE/BLUECHIP","NSE/NOESISIND","NSE/SKSMICRO","NSE/RELIGAREGO","NSE/RELGRNIFTY","NSE/BLUESTINFO","NSE/SURYAJYOTI","NSE/PARAPRINT","NSE/RMMIL","NSE/LUMAXAUTO","NSE/KEMROCK","NSE/HMT","NSE/ACROPETAL","NSE/SHRIASTER","NSE/JCTEL","NSE/FRL","NSE/FRLDVR","NSE/WANBURY","NSE/VISUINTL","NSE/UMESLTD","NSE/TNTELE","NSE/TECHIN","NSE/SRGINFOTEC","NSE/SGFL","NSE/TODAYS","NSE/THOMASCOTT","NSE/RUCHINFRA","NSE/PILANIINVS","NSE/PARASPETRO","NSE/SPECTACLE","NSE/SOFTTECHGR","NSE/SIL","NSE/NORBTEAEXP","NSE/NEPCMICON","NSE/NATNLSTEEL","NSE/NICCO","NSE/MOTOGENFIN","NSE/RAMSARUP","NSE/REISIXTEN","NSE/RADAAN","NSE/QUINTEGRA","NSE/PRADIP","NSE/ZENITHBIR","NSE/XLENERGY","NSE/KERNEX","NSE/KALYANIFRG","NSE/JIKIND","NSE/REGENCERAM","NSE/NET4","NSE/JAINSTUDIO","NSE/JAIHINDPRO","NSE/MALWACOTT","NSE/KHAITANLTD","NSE/GOENKA","NSE/GLFL","NSE/GISOLUTION","NSE/GEINDSYS","NSE/EUROMULTI","NSE/ENTEGRA","NSE/EIMCOELECO","NSE/DSSL","NSE/DUNCANSLTD","NSE/INDOWIND","NSE/AICHAMP","NSE/GANGOTRI","NSE/BIRLAERIC","NSE/BILPOWER","NSE/BGLOBAL","NSE/ASIL","NSE/ANTGRAPHIC","NSE/ANIKINDS","NSE/ALPA","NSE/CURATECH","NSE/CUBEXTUB","NSE/BROADCAST","NSE/LFIC","NSE/DYNATECH","NSE/ARROWCOAT","NSE/PALREDTECH","NSE/STYABS","NSE/DIGJAM","NSE/UTTAMVALUE","NSE/PIPAVAVDOC","NSE/KIL","NSE/NIFTY_MIDCAP_LIQUID_15","NSE/LIX15_MIDCAP","NSE/MAX","NSE/ESSAROIL","NSE/WELSYNTEX","NSE/PFRL","NSE/ABCIL","NSE/PLETHICO","NSE/SIRPAPER","NSE/NCOPPER","NSE/MURLIIND","NSE/GUJSTATFIN","NSE/INNOIND","NSE/ARVINDREM","NSE/ZENITHCOMP","NSE/COREEDUTEC","NSE/CMAHENDRA","NSE/ERAINFRA","NSE/ELDERPHARM","NSE/EXCELINFO","NSE/VARUNSHIP","NSE/PROZONE","NSE/UBENGG","NSE/MVLIND","NSE/SSLT","NSE/APIL","NSE/KTKNV20ETF","NSE/ALFALAVAL","NSE/AHMEDFORGE","NSE/PIRGLASS","NSE/FTCPOF5YDV","NSE/ORIENTCERA","NSE/CMC","NSE/STER","NSE/RELMEDIA","NSE/SEZALGLASS","NSE/GULFOILCOR","NSE/FAME","NSE/SHASUNPHAR","NSE/ROMAN","NSE/VTXIND","NSE/ZENITHINFO","NSE/HOPFL","NSE/MAHINDFORG","NSE/PEPL","NSE/EONELECT","NSE/NORTHGATE","NSE/CNX_NIFTY_JUNIOR","NSE/CNXENERGY","NSE/SBTINTL","NSE/HYDRBADIND","NSE/KALECONSUL","NSE/GEODESIC","NSE/SAMINDUS","NSE/KFA","NSE/SAKTHIFIN","NSE/AGRE","NSE/PIRLIFE","NSE/BSTRANSCOM","NSE/VARUN","NSE/RESURGERE","NSE/CINEMAX","NSE/WELPROJ","NSE/BELLCERATL","NSE/PANCHSHEEL","NSE/KITPLYIND","NSE/NUMERICPW","NSE/DALMIABEL","NSE/PILIND","NSE/DCB","NSE/NAVNETPUBL","NSE/UTVSOF","NSE/TELEMARINE","NSE/BATLIBOI","NSE/HGSL","NSE/KSOILS","NSE/JUPITER","NSE/BHARTISHIP","NSE/TULSYAN","NSE/SAYAJIHOTL","NSE/KOVAI","NSE/CILNOVA","NSE/GKB","NSE/ACKRUTI","NSE/LANCOIN","NSE/PERIATEA","NSE/WELGLOB","NSE/AMAR","NSE/KOPDRUGS","NSE/ZUARIAGRO","NSE/KLRF","NSE/SATYAMCOMP","NSE/FOURSOFT","NSE/ABHISHEK","NSE/HORIZONINF","NSE/FUTUREVENT","NSE/FCH","NSE/SIMPLEXCAS","NSE/KRITIIND","NSE/ZEENEWS","NSE/INEABS","NSE/SBIGETS","NSE/ASTERSILI","NSE/GSLNOVA","NSE/NOL","NSE/DENSO","NSE/HIRAFERRO","NSE/SURYAPHARM","NSE/CNXFINANCE","NSE/NIFTYMIDCAP","NSE/IPGETF","NSE/PROVOGUE","NSE/WWIL","NSE/EMPEESUG","NSE/CLUTCHAUTO","NSE/UNIPHOS","NSE/CPIL","NSE/PALRED","NSE/PARAL","NSE/ARL","NSE/CNX_DEFTY","NSE/GLORY","NSE/DRDATSONS","NSE/DCMSRMCONS","NSE/IOLN","NSE/SHREEASHTA","NSE/JUMBO","NSE/PATNI","NSE/CAMBRIDGE","NSE/LLOYDFIN","NSE/INDIAINFO","NSE/SALONACOT","NSE/CRONIMET","NSE/NANDAN","NSE/MICROTECH","NSE/CLASSIC","NSE/SHARRESLTD","NSE/SUNCLAYTON","NSE/INDUSFILA","NSE/DEWANHOUS","NSE/CAROLINFO","NSE/AVENTIS","NSE/DUNCANSIND","NSE/PIRHEALTH","NSE/CINEPRO","NSE/BIMETAL","NSE/NEOCORP","NSE/CAMLIN","NSE/ELFORGE","NSE/SRHHLINDST","NSE/PROZONECSC","NSE/ELNET","NSE/DHANUS","NSE/AXIS_ITT","NSE/CNXMEDIA","NSE/KOUTONS","NSE/PRETAILDVR","NSE/WYETH","NSE/TCPLTD","NSE/KARURKCP","NSE/DECOLIGHT","NSE/ESSARPORTS","NSE/AMARJOTHI","NSE/PANCARBON","NSE/HALONIX","NSE/AFTEK","NSE/BRANDHOUSE","NSE/SHLAKSHMI","NSE/SETFNIFJR","NSE/SETFNIFTY","NSE/SIMBHSUGAR","NSE/THEBYKE","NSE/NANDANEXIM","NSE/SRICHAMUND","NSE/FTCSF5YDIV","NSE/TEXMACOLTD","NSE/IBSEC","NSE/IVRCLAH","NSE/FTCSF5YGRO","NSE/DPTL","NSE/MLL","NSE/MMWL","NSE/GULFCORP","NSE/MANJEERA","NSE/VIPUL","NSE/BECREL","NSE/CNXSMALLCAP","NSE/NEOCURE","NSE/SIGNETIND","NSE/CNXMETAL","NSE/SAMBANDAM","NSE/SAVERA","NSE/PILANIINV","NSE/IPRINGLTD","NSE/RAJPALAYAM","NSE/DALMIAREF","NSE/MUDRA","NSE/ALPINEHOU","NSE/INGVYSYABK","NSE/IIFLNIFTY","NSE/SKUMARSYNF","NSE/PRITHVI","NSE/SHIV_VANI","NSE/TECPRO","NSE/RANBAXY","NSE/MGOLD","NSE/VAKRANSOFT","NSE/SPANCO","NSE/SPCNXNIFTYSHARIAH","NSE/MUNDRAPORT","NSE/MBSWITCH","NSE/FTCPOF5YGR","NSE/CNXREALTY","NSE/NEHAINT","NSE/VAIBHAVGEM","NSE/THINKSOFT","NSE/SPCNX500","NSE/NIFTYMIDCAP50","NSE/VIKASHMET","NSE/MMFSL","NSE/BOC","NSE/INFOTECENT","NSE/INDIABULLS","NSE/FKONCO","NSE/ASHCONIUL","NSE/COROENGG","NSE/LAKSHMIMIL","NSE/SPCNX","NSE/MORARJETEX","NSE/CNXPSUBANK","NSE/NATHSEED","NSE/CNXMIDCAP","NSE/BODHTREE","NSE/EDSERV","NSE/CORAL_HUB","NSE/VISHALRET","NSE/SENTINEL","NSE/ANKURDRUGS","NSE/AANJANEYA","NSE/BHAGWATIHO","NSE/CNXAUTO","NSE/AMLSTEEL","NSE/RAINCOM","NSE/PONDYOXIDE","NSE/KSE","NSE/KINETICMOT","NSE/FIRSTLEASE","NSE/KLGSYSTEL","NSE/SURAJDIAMN","NSE/SESAGOA","NSE/BIRLAPOWER","NSE/JSWISPAT","NSE/NOVOPANIND","NSE/SUJANATOW","NSE/TELEDATAIT","NSE/CREWBOS","NSE/MADRASCEM","NSE/CHEMPLAST","NSE/CNXDIVIDENDOPPT","NSE/CNXPSE","NSE/NIFTYDIVIDEND","NSE/CNX100","NSE/DCHL","NSE/SARTHAKIND","NSE/OSWALMIN","NSE/TANFACIND","NSE/APPAPER","NSE/PANTALOONR","NSE/CNXCONSUMPTION","NSE/JDORGOCHEM","NSE/CNXPHARMA","NSE/CNXINFRA","NSE/SMOBILITY","NSE/CNXFMCG","NSE/TAKSHEEL","NSE/CHETTINAD","NSE/GRABALALK","NSE/SHRINATRAJ","NSE/NUCHEM","NSE/TULIP","NSE/SPCNXDEFTY","NSE/RANKLIN","NSE/NRC","NSE/A2ZMES","NSE/APLAB","NSE/HYDROSS","NSE/CNX200","NSE/UTISUNDER","NSE/SPCNX500SHARIAH","NSE/AVANTI","NSE/CNXHIGHBETA","NSE/CASTROL","NSE/VTMLTD","NSE/MAHINDUGIN","NSE/CNXALPHAINDEX","NSE/POLARIND","NSE/JEYPORE","NSE/INFODRIVE","NSE/CNXLOWVOLATILITY","NSE/RBN","NSE/HELIOSMATH","NSE/NUCENT","NSE/PRITHVISOF","NSE/PEACOCKIND","NSE/JINDALSWHL","NSE/CNXMIDCAP200","NSE/CNXSERVICE","NSE/LLOYDSTEEL","NSE/LAKSHMIFIN","NSE/CRESTANI","NSE/CNXNIFTYJUNIOR","NSE/IBIPL","NSE/IBPOW","NSE/AQUA","NSE/CNXCOMMODITIES","NSE/CNXMNC","NSE/TTKHEALTH","NSE/SURANAVEL","NSE/GUJSIDHCEM","NSE/SUPER","NSE/SPCNXSHARIAH","NSE/CNXIT","NSE/SPESGINDIAINDEX","NSE/CNX","NSE/CNXBANK","NSE/SOUISPAT","NSE/KANDAGIRI","NSE/PANASONIC","NSE/MARG","NSE/TWILITAKA","NSE/LOGIXMICRO","NSE/KBIL","NSE/COMPUAGE","NSE/SABERORGAN","NSE/WINSOMEDJ","NSE/WELENTRP","NSE/MANJUSHREE","NSE/SAHPETRO","NSE/KRISHNAENG","NSE/CHESLINTEX","NSE/GLODYNE","NSE/ORCHIDCHEM","NSE/VIKASGLOB","NSE/GUJRATGAS","NSE/MAKE","NSE/AMTEKINDIA","NSE/TIMBOR","NSE/SETFBANK","NSE/LICNFENGP","NSE/LICNMFET"};



        // ========================----====================

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backPressed++;
        if(backPressed == 2) {
            super.onBackPressed();
            finishAffinity();

        }
        else
        {
            Toast.makeText(MainActivity.this,"Press back once again to exit", Toast.LENGTH_LONG).show();
        }

    }
}
