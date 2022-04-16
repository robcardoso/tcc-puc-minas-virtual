export const DADOS_CIDADE = [
  {
    "estados": [
      {
        "sigla":"SP",
        "nome": "São Paulo",
        "codEstado": 1,
        "cidades": [
          {
            "nomeCidade": "Santos",
            "codCidade": 101
          },
          {
            "nomeCidade": "São Paulo",
            "codCidade": 102
          },
        ]
      },
      {
        "sigla":"MG",
        "nome": "Minas Gerais",
        "codEstado": 2,
        "cidades": [
          {
            "nomeCidade": "Belo Horizonte",
            "codCidade": 103
          },
          {
            "nomeCidade": "Lavras",
            "codCidade": 104
          },
        ]
      }
    ]
  }
]


export const DADOS_PRESTADOR = [
  {
    "cidadesPrestador": [
      {
        "nome":"Santos",
        "codCidade": 101,
        "especialidade": [
          {
            "codEspecialidade": 1,
            "nome":"clínica médica",
            "prestadores": [
              {
                "codPrestador": 9901,
                "nome":"João Paulo"
              },
              {
                "codPrestador": 9902,
                "nome":"Maria José"
              },
            ]
          },
          {
            "codEspecialidade": 2,
            "nome":"pediatria",
            "prestadores": [
              {
                "codPrestador": 9903,
                "nome":"Lucas de Assis"
              },
              {
                "codPrestador": 9904,
                "nome":"Fátima da Cruz"
              },
            ]
          }
        ]
      },
      {
        "nome":"São Paulo",
        "codCidade": 102,
        "especialidade": [
          {
            "codEspecialidade": 1,
            "nome":"clínica médica",
            "prestadores": [
              {
                "codPrestador": 9905,
                "nome":"Francisco"
              },
              {
                "codPrestador": 9906,
                "nome":"Maria Aparecida"
              },
            ]
          },
          {
            "codEspecialidade": 2,
            "nome":"pediatria",
            "prestadores": [
              {
                "codPrestador": 9907,
                "nome":"Pedro Paulo"
              },
              {
                "codPrestador": 9908,
                "nome":"Lourdes"
              },
            ]
          }
        ]
      },
      {
        "nome":"Belo Horizonte",
        "codCidade": 103,
        "especialidade": [
          {
            "codEspecialidade": 1,
            "nome":"clínica médica",
            "prestadores": [
              {
                "codPrestador": 9909,
                "nome":"Fafael"
              },
              {
                "codPrestador": 9910,
                "nome":"Gabriel"
              },
            ]
          },
          {
            "codEspecialidade": 2,
            "nome":"pediatria",
            "prestadores": [
              {
                "codPrestador": 9911,
                "nome":"Miguel de Assis"
              },
              {
                "codPrestador": 9912,
                "nome":"Madalena"
              },
            ]
          }
        ]
      },
      {
        "nome":"Lavras",
        "codCidade": 104,
        "especialidade": [
          {
            "codEspecialidade": 1,
            "nome":"clínica médica",
            "prestadores": [
              {
                "codPrestador": 9913,
                "nome":"Francisco José"
              },
              {
                "codPrestador": 9914,
                "nome":"Maria de Fátima"
              },
            ]
          },
          {
            "codEspecialidade": 2,
            "nome":"pediatria",
            "prestadores": [
              {
                "codPrestador": 9915,
                "nome":"Thiago"
              },
              {
                "codPrestador": 9916,
                "nome":"Tomé"
              },
            ]
          }
        ]
      }
    ]
  }
]
