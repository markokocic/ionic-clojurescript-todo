(ns ion.core
  (:refer-clojure :exclude [range list])
  (:require
   [reagent.core :as r]
   ["@ionic/react" :as i]))

(defn- adapt-class [class]
  (when class
    (r/adapt-react-class class)))

;; Action Sheet
(def action-sheet (adapt-class i/IonActionSheet))
;; Accordion
(def accordion (adapt-class i/IonAccordion))
(def accordion-group (adapt-class i/IonAccordionGroup))
;; Alert
(def alert (adapt-class i/IonAlert))
;; Badge
(def badge (adapt-class i/IonBadge))
;; Breadcrumb
(def breadcrumb (adapt-class i/IonBreadcrumb))
(def breadcrumbs (adapt-class i/IonBreadcrumbs))
;; Button
(def button (adapt-class i/IonButton))
(def ripple-effect (adapt-class i/IonRippleEffect))
;; Card
(def card (adapt-class i/IonCard))
(def card-content (adapt-class i/IonCardContent))
(def card-header (adapt-class i/IonCardHeader))
(def card-subtitle (adapt-class i/IonCardSubtitle))
(def card-title (adapt-class i/IonCardTitle))
;; Checkbox
(def checkbox (adapt-class i/IonCheckbox))
;; Chip
(def chip (adapt-class i/IonChip))
;; Content
(def content (adapt-class i/IonContent))
(def app (adapt-class i/IonApp))
;; Date & Time Pickers
(def datetime (adapt-class i/IonDatetime))
(def picker (adapt-class i/IonPicker))
;; Floating Action Button
(def fab (adapt-class i/IonFab))
(def fab-button (adapt-class i/IonFabButton))
(def fab-list (adapt-class i/IonFabList))
;; Grid
(def grid (adapt-class i/IonGrid))
(def col (adapt-class i/IonCol))
(def row (adapt-class i/IonRow))
;; Infinite Scroll
(def infinite-scroll (adapt-class i/IonInfiniteScroll))
(def infinite-scroll-content (adapt-class i/IonInfiniteScrollContent))
;; Icons
(def icon (adapt-class i/IonIcon))
;; Input
(def input (adapt-class i/IonInput))
(def textarea (adapt-class i/IonTextarea))
;; Item
(def item (adapt-class i/IonItem))
(def item-divider (adapt-class i/IonItemDivider))
(def item-group (adapt-class i/IonItemGroup))
(def item-sliding (adapt-class i/IonItemSliding))
(def item-options (adapt-class i/IonItemOptions))
(def item-option (adapt-class i/IonItemOption))
(def label (adapt-class i/IonLabel))
(def note (adapt-class i/IonNote))
;; List
(def list (adapt-class i/IonList))
(def list-header (adapt-class i/IonListHeader))
(def virtual-scroll (adapt-class i/IonVirtualScroll))
;; Media
(def avatar (adapt-class i/IonAvatar))
(def img (adapt-class i/IonImg))
(def thumbnail (adapt-class i/IonThumbnail))
;; Menu
(def menu (adapt-class i/IonMenu))
(def menu-button (adapt-class i/IonMenuButton))
(def menu-toggle (adapt-class i/IonMenuToggle))
(def split-pane (adapt-class i/IonSplitPane))
;; Modal
(def modal (adapt-class i/IonModal))
(def backdrop (adapt-class i/IonBackdrop))
;; Navigation
(def nav (adapt-class i/IonNav))
(def nav-link (adapt-class i/IonNavLink))
;; Popover
(def popover (adapt-class i/IonPopover))
;; Progress Indicators
(def loading (adapt-class i/IonLoading))
(def progress-bar (adapt-class i/IonProgressBar))
(def skeleton-text (adapt-class i/IonSkeletonText))
(def spinner (adapt-class i/IonSpinner))
;; Radio
(def radio (adapt-class i/IonRadio))
(def radio-group (adapt-class i/IonRadioGroup))
;; Range
(def range (adapt-class i/IonRange))
;; Refrescher
(def refresher (adapt-class i/IonRefresher))
(def refresher-content (adapt-class i/IonRefresherContent))
;; Reorder
(def reorder (adapt-class i/IonReorder))
(def reorder-group (adapt-class i/IonReorderGroup))
;; Routing
;; (def router (adapt-class i/IonRouter))
(def router-link (adapt-class i/IonRouterLink))
(def router-outlet (adapt-class i/IonRouterOutlet))
(def route (adapt-class i/IonRoute))
;; (def route-redirect (adapt-class i/IonRouteRedirect))
;; Searchbar
(def searchbar (adapt-class i/IonSearchbar))
;; Segment
(def segment (adapt-class i/IonSegment))
(def segment-button (adapt-class i/IonSegmentButton))
;; Slides
(def slides (adapt-class i/IonSlides))
(def slide (adapt-class i/IonSlide))
;; Tabs
(def tabs (adapt-class i/IonTabs))
(def tab (adapt-class i/IonTab))
(def tab-bar (adapt-class i/IonTabBar))
(def tab-button (adapt-class i/IonTabButton))
;; Toast
(def toast (adapt-class i/IonToast))
;; Toggle
(def toggle (adapt-class i/IonToggle))
;; Toolbar
(def toolbar (adapt-class i/IonToolbar))
(def header (adapt-class i/IonHeader))
(def footer (adapt-class i/IonFooter))
(def title (adapt-class i/IonTitle))
(def buttons (adapt-class i/IonButtons))
(def back-button (adapt-class i/IonBackButton))
;; Typography
(def text (adapt-class i/IonText))

;; functions
(def setup-ionic-react i/setupIonicReact)
