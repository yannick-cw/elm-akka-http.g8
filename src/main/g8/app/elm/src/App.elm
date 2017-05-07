module Main exposing (..)

import Html exposing (program)
import Json.Decode exposing (field)
import Json.Decode as Decode
import Http
import Html exposing (..)
import Html.Attributes exposing (..)
import Html.Events exposing (onClick)


main =
    program
        { init = init
        , view = view
        , update = update
        , subscriptions = subscriptions
        }



-- MODEL


type alias Model =
    String


type Msg
    = Ping
    | Pong (Result Http.Error String)


init : ( Model, Cmd Msg )
init =
    ( "", Cmd.none )



-- UPDATE


update : Msg -> Model -> ( Model, Cmd Msg )
update msg model =
    case msg of
        Ping ->
            ( model, doPing )

        Pong (Ok pong) ->
            ( pong, Cmd.none )

        Pong (Err er) ->
            ( model, Cmd.none )



-- VIEW


view : Model -> Html Msg
view model =
    div []
        [ button [ onClick Ping ] [ text "Ping" ]
        , h2 [] [ text model ]
        ]



-- HTTP


doPing : Cmd Msg
doPing =
    let
        url =
            "/ping"

        request =
            Http.get url decodePong
    in
        Http.send Pong request


decodePong : Decode.Decoder String
decodePong =
    Decode.at [ "pong" ] Decode.string



-- SUBSCRIPTIONS


subscriptions : Model -> Sub Msg
subscriptions model =
    Sub.none
